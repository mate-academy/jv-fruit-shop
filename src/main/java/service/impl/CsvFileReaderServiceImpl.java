package service.impl;

import service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromCsvFile(String fileName) {
        List<String> fruitTransactions = new ArrayList<>();
        try {
            fruitTransactions = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file named: " + fileName, e);
        }
        return fruitTransactions;
    }
}