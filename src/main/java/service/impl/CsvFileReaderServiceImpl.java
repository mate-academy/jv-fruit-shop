package service.impl;

import service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromCsvFile(String fileName) {
        if (fileName == null || !fileName.endsWith(".csv")) {
            throw new RuntimeException("Incorrect file name or extension!");
        }
        List<String> fruitTransactions;
        try {
            fruitTransactions = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file named: " + fileName, e);
        }
        return fruitTransactions;
    }
}