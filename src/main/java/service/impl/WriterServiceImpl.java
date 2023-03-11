package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.general.WriterService;

public class WriterServiceImpl implements WriterService {
    public void writeToFile(String report, String reportPath) {
        Path filePath = Path.of(reportPath);
        try {
            Files.deleteIfExists(filePath);
            Files.write(filePath, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to perform operations with " + reportPath, e);
        }
    }
}
