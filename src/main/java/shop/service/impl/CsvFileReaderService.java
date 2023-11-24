package shop.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import shop.service.FileReaderService;

public class CsvFileReaderService implements FileReaderService {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public List<String[]> readFile(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(COMMA_DELIMITER));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
        return records;
    }
}
