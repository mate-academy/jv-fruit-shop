package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String filePath, String content) {
        create(filePath);
        try {
            Files.write(Path.of(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to this file " + filePath);
        }
    }

    private Path create(String fileName) {
        try {
            return Files.createFile(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't create file in this folder " + fileName);
        }
    }
}
