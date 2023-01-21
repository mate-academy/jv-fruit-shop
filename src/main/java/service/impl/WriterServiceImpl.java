package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String reportFilePath) {
        try {
            Files.writeString(Path.of(reportFilePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the report", e);
        }
    }
}
