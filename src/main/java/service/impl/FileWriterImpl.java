package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class FileWriterImpl implements WriterService {

    @Override
    public void write(String report, String filePath) {
        if (report == null || filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("Invalid input");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write file: " + filePath, e);
        }
    }
}
