package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String report, String reportPath) {
        Path filePath;
        try {
            filePath = Path.of(reportPath);
            Files.deleteIfExists(filePath);
            Files.write(filePath, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to perform operations with " + reportPath, e);
        }
    }
}
