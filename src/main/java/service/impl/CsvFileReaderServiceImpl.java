package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.CsvFileReaderService;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .skip(1) // Skip header line
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }
    }
}
