package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String ERROR = "Failed to write report: ";

    @Override
    public void writeReport(String report, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
    }
}
