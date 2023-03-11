package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.Reader;

public class CsvReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> fruitData = new ArrayList<>();
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = readFromFile.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file", e);
        }
        return fruitData;
    }
}
