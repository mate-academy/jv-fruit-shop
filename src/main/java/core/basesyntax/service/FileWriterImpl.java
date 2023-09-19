package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {
        try (java.io.FileWriter writer = new java.io.FileWriter(OUTPUT_FILE_NAME);
                BufferedWriter bwr = new BufferedWriter(writer)) {
            bwr.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + OUTPUT_FILE_NAME);
        }
    }
}
