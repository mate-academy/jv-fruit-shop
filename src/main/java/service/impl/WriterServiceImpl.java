package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String EXCEPTION_MESSAGE = "Can't write report to file: ";

    @Override
    public void write(String report, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + filePath);
        }
    }
}
