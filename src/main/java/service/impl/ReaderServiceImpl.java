package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fromFilePath) {
        try {
            return Files.readAllLines(Path.of(fromFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fromFilePath, e);
        }
    }
}
