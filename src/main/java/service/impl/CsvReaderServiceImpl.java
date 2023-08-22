package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import service.CsvReaderService;

public class CsvReaderServiceImpl implements CsvReaderService {
    @Override
    public String[] readFromFile(String fileName) {
        StringBuilder dataFromFile = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                dataFromFile.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find or read file", e);
        }
        return dataFromFile.toString().split(System.lineSeparator());
    }
}

