package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WritingService;

public class WritingServiceImpl implements WritingService {

    @Override
    public void writeToFile(String text, String filePath) {
        try {
            Files.write(Path.of(filePath), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write to this file: " + filePath, e);
        }
    }
}
