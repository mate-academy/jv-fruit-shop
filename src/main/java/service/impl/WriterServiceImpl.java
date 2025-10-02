package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String report, String filePath) {
        if (report == null || report.isBlank()) {
            throw new IllegalArgumentException("Report cannot be null or empty");
        }
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can't write file by path: " + filePath, e
            );
        }
    }
}
