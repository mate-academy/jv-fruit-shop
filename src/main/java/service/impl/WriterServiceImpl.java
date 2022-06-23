package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String EMPTY_REPORT = "There is nothing to report";

    @Override
    public void write(String report, String filePath) {
        File reportFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            if (report == null || report.isEmpty()) {
                writer.write(EMPTY_REPORT);
            }
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file");
        }
    }
}
