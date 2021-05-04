package main.service.impl;

import main.service.interfaces.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String READ_FAILED = "Can't read file ";

    @Override
    public List<String> readLines(Path filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(READ_FAILED + filePath);
        }
        return lines;
    }
}
