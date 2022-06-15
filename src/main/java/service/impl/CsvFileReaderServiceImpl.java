package service.impl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import service.FileReaderService;

public class CsvFileReaderServiceImpl implements FileReaderService {
    public List<String[]> readFile(String filePath) {
        File file = new File(filePath);
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + file.getName() + e);
        }
    }
}
