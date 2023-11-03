package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String data, String outputPath) {
        try {
            Files.writeString(Path.of(outputPath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + outputPath, e);
        }
    }
}
