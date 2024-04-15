package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String PATH_TO_REPORT_FILE = "src/main/java/resources/Report.csv";

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_REPORT_FILE))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + PATH_TO_REPORT_FILE, e);
        }
    }
}
