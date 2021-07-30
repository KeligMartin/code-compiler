package fr.adventofcode.backend.compiler.infrastructure.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileService {

  String homeDir = System.getProperty("user.dir");

  public List<String> getResult(File file) throws IOException {
    log.info("Read file..");
    Path path = Paths.get(homeDir + "/" + file);
    return new ArrayList<>(Files.readAllLines(path));
  }

  public void writeInFile(File file, String content) throws IOException {
    log.info("Writing in file");
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(content);
    fileWriter.close();
    log.info("Writing in file end");
  }

  public File createFile(String path) throws IOException {
    File file = new File(path);
    if (file.createNewFile()) {
      log.info("File created");
    } else {
      log.info("File already exist");
    }
    return file;
  }

  public File createFolder(String path) {
    File folder = new File(path);
    if (folder.mkdir()) {
      log.info("Folder created");
    } else {
      log.info("Folder already exist");
    }
    return folder;
  }
}
