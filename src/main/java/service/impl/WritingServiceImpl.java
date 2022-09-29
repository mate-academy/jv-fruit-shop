package service.impl;

import service.WritingService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
