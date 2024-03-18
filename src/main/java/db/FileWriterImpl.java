package db;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private static final String REPORT_PATH = "src/main/resources/dailyReport.csv";

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(REPORT_PATH))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Incorrect path name!");
        }
    }
}
