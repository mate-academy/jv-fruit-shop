package fruitshop.service.files.impl;

import fruitshop.service.files.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    public List<String> readFromFile(Path csvFilePath) {
        try {
            return Files.readAllLines(csvFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file: ", e);
        }
    }
}
