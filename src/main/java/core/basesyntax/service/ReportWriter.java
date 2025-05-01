package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter implements FileWriter {

    @Override
    public void writeReport(String report, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + outputFile, e);
        }
    }
}
