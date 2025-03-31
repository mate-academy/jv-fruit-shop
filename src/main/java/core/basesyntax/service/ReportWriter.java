package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    private final ReportContentGenerator reportContentGenerator = new ReportContentGenerator();

    public void writeReport(String outputFile) throws IOException {

        String reportContent = reportContentGenerator.generateReportContent();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + outputFile, e);
        }
    }
}
