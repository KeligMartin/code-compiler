package fr.adventofcode.backend.compiler.application.dto;

public class CompileResponse {
    private String output ;

    private Boolean error;

    private Boolean resolved;

    private String expectedOutput;

    private Float executionTime;

    public CompileResponse(String output, Boolean error, Boolean resolved, String expectedOutput, Float executionTime) {
        this.output = output;
        this.error = error;
        this.resolved = resolved;
        this.expectedOutput = expectedOutput;
        this.executionTime = executionTime;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public Float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Float executionTime) {
        this.executionTime = executionTime;
    }

    //TODO temps d'execution

    //TODO donner un nom au testCase
}
