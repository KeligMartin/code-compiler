package fr.adventofcode.backend.compiler.domain;

public class LanguageRunImage {
    private String imageName;

    private String workDir;

    private String extension;


    public LanguageRunImage(String imageName, String workDir, String extension) {
        this.imageName = imageName;
        this.workDir = workDir;
        this.extension = extension;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getWorkDir() {
        return workDir;
    }

    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }


    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
