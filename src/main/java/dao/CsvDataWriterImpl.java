package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvDataWriterImpl implements CsvDataWriter {
    @Override
    public void writeToFile(String reportFile, String reportData) {
        if (reportFile == null || reportFile.trim().isEmpty()
                || reportData == null || reportData.trim().isEmpty()) {
            throw new IllegalArgumentException("File path or report data cannot be empty");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile))) {
            bufferedWriter.write(reportData);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + reportFile, e);
        }
    }
}
