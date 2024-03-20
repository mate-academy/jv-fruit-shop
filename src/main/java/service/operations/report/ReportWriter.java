package service.operations.report;

import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    public static void writeReportToFile(String reportContent, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(reportContent);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to file", e);
        }
    }
}
