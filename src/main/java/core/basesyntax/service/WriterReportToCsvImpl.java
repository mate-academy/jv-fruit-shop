package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterReportToCsvImpl implements WriterReportToCsv {
    @Override
    public void writeReport(String report, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + outputFilePath, e);
        }
    }
}
