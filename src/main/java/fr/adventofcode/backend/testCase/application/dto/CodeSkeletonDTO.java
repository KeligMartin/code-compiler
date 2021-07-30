package fr.adventofcode.backend.testCase.application.dto;

import fr.adventofcode.backend.language.domain.Language;

public class CodeSkeletonDTO {
  private final String code;

  private final Language language;

  private final String idStatement;

  private final String expectedOutput;

  public CodeSkeletonDTO(
      String code,
      Language language,
      String idStatement,
      String expectedOutput) {
    this.code = code;
    this.language = language;
    this.idStatement = idStatement;
    this.expectedOutput = expectedOutput;
  }

  public String getExpectedOutput() {
    return expectedOutput;
  }

  public String getCode() {
    return code;
  }

  public Language getLanguage() {
    return language;
  }

  public String getIdStatement() {
    return idStatement;
  }

}
