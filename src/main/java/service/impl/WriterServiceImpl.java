package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String finalReport, String filePath) {
        try {
            Files.writeString(Path.of(filePath), finalReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + filePath, e);
        }
    }
}
