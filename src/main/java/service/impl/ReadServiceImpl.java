package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadService;

public class ReadServiceImpl implements ReadService {
    @Override
    public List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName, e);
        }
    }
}
