package service.read.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.read.ReadFileService;

public class ReadFileServiceImpl implements ReadFileService {
    private static final String CANT_READ_MESSAGE = "Can't read from file: ";

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_MESSAGE + filePath);
        }
    }
}
