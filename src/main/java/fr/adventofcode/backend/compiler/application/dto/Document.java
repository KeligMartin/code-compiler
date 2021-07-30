package fr.adventofcode.backend.compiler.application.dto;

public class Document {
    private String userFolderName ;
    private String folderPath ;
    private String filePath;

    public Document(String userFolderName, String folderPath, String filePath) {
        this.userFolderName = userFolderName;
        this.folderPath = folderPath;
        this.filePath = filePath;

    }

    public String getUserFolderName() {
        return userFolderName;
    }

    public void setUserFolderName(String userFolderName) {
        this.userFolderName = userFolderName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}
