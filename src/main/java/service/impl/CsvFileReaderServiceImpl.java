package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.CsvFileReaderService;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final long OFFSET = 1;

    @Override
    public List<String> readFromFile(String filePath) {
        try (var lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .skip(OFFSET)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file by path: " + filePath, e);
        }
    }
}
