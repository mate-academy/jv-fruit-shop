package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class CsvDataReader implements ReaderService {
    public static final String SEPARATOR = ",";
    private List<String[]> records = new ArrayList<>();

    @Override
    public List<String[]> readFromCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEPARATOR);
                records.add(values);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return records;
    }
}
