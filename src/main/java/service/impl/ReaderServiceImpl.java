package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(filePath))) {
            csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null) {
                result.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found at " + filePath, e);
        }
        return result;
    }
}
