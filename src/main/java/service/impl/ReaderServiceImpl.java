package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fromFilePath) {
        Path path = Path.of(fromFilePath);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from your amazing file "
            + path + " !", e);
        }
    }
}
