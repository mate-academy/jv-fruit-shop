package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.ReadingService;
import java.nio.file.Path;

public class ReadingServiceImpl implements ReadingService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cant read from this file: " + filePath);
        }

        return list;
    }
}
