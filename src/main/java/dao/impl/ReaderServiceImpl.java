package dao.impl;

import dao.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private final String filePath;

    public ReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> get() {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from this file " + filePath);
        }
    }
}
