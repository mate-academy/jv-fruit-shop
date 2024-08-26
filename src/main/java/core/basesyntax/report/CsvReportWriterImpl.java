package core.basesyntax.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String reportData, String filePath) {
        try (BufferedWriter reportWriter = new BufferedWriter(new FileWriter(filePath))) {
            reportWriter.write(reportData);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write report to file: " + filePath, e);
        }
    }
}
