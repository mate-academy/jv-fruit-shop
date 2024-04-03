package core.basesyntax.service;

import java.io.IOException;

public class FileWriter {
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public void write(String text) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(REPORT_FILE_NAME)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + REPORT_FILE_NAME, e);
        }
    }
}
