package dao.impl;

import dao.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private final String filePath;

    public WriterServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(String content) {
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
