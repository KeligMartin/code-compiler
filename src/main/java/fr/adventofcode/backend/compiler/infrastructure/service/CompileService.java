package fr.adventofcode.backend.compiler.infrastructure.service;

import fr.adventofcode.backend.compiler.application.dto.CompileResponse;
import fr.adventofcode.backend.compiler.application.dto.Document;
import fr.adventofcode.backend.compiler.domain.Compile;
import fr.adventofcode.backend.compiler.domain.LanguageRunImage;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.testCase.application.FindTestCaseByIdTestCase;
import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.userResponse.application.AddUserResponse;
import fr.adventofcode.backend.userResponse.application.dto.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CompileService {

    String homeDir = System.getProperty("user.dir");

    private final FileService fileService;

    private final FindTestCaseByIdTestCase findTestCaseByIdTestCase;

    private final AddUserResponse addUserResponse;

    @Autowired
    public CompileService(FileService fileService, FindTestCaseByIdTestCase findTestCaseByIdTestCase, AddUserResponse addUserResponse) {
        this.fileService = fileService;
        this.findTestCaseByIdTestCase = findTestCaseByIdTestCase;
        this.addUserResponse = addUserResponse;
    }

    public String readInputStream(InputStream inputStream) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    //TODO a gerer en bdd table imageLanguage avec le workdir pour le rendre dynamique
    public LanguageRunImage getImages(Language language) {
        switch (language) {
            case C:
                return new LanguageRunImage("gcc:4.9", "c", "c");
            case JAVA:
                return new LanguageRunImage("openjdk:8", "java", "java");
            case PYTHON:
                return new LanguageRunImage("python:3", "python", "py");

            default:
                return null;
        }
    }


    //TODO ajouter l'enregistrement en bdd du resolved iserror en bdd
    //TODO a changer le code quality
    public CompileResponse compile(Compile compile, String idAccount) throws IOException {
        LanguageRunImage languageRunImage = getImages(compile.getLanguage());
        Document document = createDocumentInfo(idAccount, compile, languageRunImage);
        return getCompileResponses(compile, languageRunImage, document,idAccount);
    }

    private void saveResult(String code,Language language,String idStatement,String idAccount){
        UserResponseDTO userResponseDTO=new UserResponseDTO(code,null,null,idStatement,language);
        this.addUserResponse.execute(userResponseDTO,idAccount);
    }

    private Document createDocumentInfo(String idAccount, Compile compile, LanguageRunImage languageRunImage)
            throws IOException {
        String userFolderName = idAccount + compile.getIdStatement() + compile.getLanguage();
        String folderPath = System.getProperty("user.home")+"/"+ languageRunImage.getWorkDir() + "/" + userFolderName;
        String filePath =  System.getProperty("user.home")+"/"+languageRunImage.getWorkDir() + "/" + userFolderName + "/Main." + languageRunImage
                .getExtension();

        return new Document(userFolderName, folderPath, filePath);
    }

    private CompileResponse getCompileResponses(Compile compile, LanguageRunImage languageRunImage,
                                                Document document,String idAccount) {
        TestCase testCase = findTestCaseByIdTestCase.execute(compile.getIdTestCase());


        return getCompile(compile, languageRunImage, document, idAccount, testCase);
    }

    private CompileResponse getCompile(Compile compile, LanguageRunImage languageRunImage, Document document, String idAccount, TestCase testCase) {
        CompileResponse compileResponse = null;
        try {
            File folder= fileService.createFolder(document.getFolderPath());
            File file=fileService.createFile(document.getFilePath());
            String codeToCompile = String.format(testCase.getCode(), compile.getCode());

            log.info(codeToCompile);
            fileService.writeInFile(file, codeToCompile);

            ProcessBuilder dockerRunPb = new ProcessBuilder("docker", "run", "--rm", "-v",
                    System.getProperty("user.home") + "/" + languageRunImage
                            .getWorkDir() + ":/" + document.getFolderPath(),
                    "-w", "/" + document.getFolderPath(),
                    languageRunImage.getImageName(),
                    "sh", "exec.sh", document.getUserFolderName(), "Main"
            );

            log.info("Running image" + languageRunImage.getImageName() + "...");

            long startTime = System.nanoTime();
            Process dockerRunProcess = dockerRunPb.start();
            long stopTime = System.nanoTime();

            boolean error = isError(dockerRunProcess);
            String outputResult = readInputStream(getInputStream(dockerRunProcess, error));
            log.info("output");
            log.info(outputResult);
            boolean resolved = isResolved(testCase.getExpectedOutput(), error, outputResult);
            compileResponse = new CompileResponse(outputResult, error, resolved,
                    testCase.getExpectedOutput().replaceAll("<br/>","\n"), getTimeExecutionInMillisecond(startTime, stopTime));



            log.info(folder.getAbsolutePath());

            FileUtils.deleteDirectory(folder);

            log.info("Running succeed!");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return compileResponse;
    }

    public Boolean timeout(Process process) throws InterruptedException {
        boolean timeout = false;
        if (!process.waitFor(120, TimeUnit.SECONDS)) {
            log.info("Timeout process");
            timeout = true;
            process.destroy();
        }
        return timeout;
    }

    public Boolean error(Process process) {
        boolean error = false;
        if (process.exitValue() != 0) {
            log.info("Something went wrong");
            error = true;
        }
        return error;
    }


    private Float getTimeExecutionInMillisecond(long startTime, long stopTime) {
        return (float) (stopTime - startTime) / 1000000;
    }

    private boolean isError(Process dockerRunProcess) throws InterruptedException {
        return timeout(dockerRunProcess) || error(dockerRunProcess);
    }

    private InputStream getInputStream(Process dockerRunProcess, boolean error) {
        return error ? dockerRunProcess.getErrorStream() : dockerRunProcess.getInputStream();
    }

    private boolean isResolved(String expectedOutput, boolean error, String outputResult) {
        return expectedOutput.equals(outputResult.replaceAll("\n", "<br/>")) && !error;
    }
}
