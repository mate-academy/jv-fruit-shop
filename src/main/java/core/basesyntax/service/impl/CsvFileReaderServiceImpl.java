package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String DELIMITER = ",";
    @Override
    public List<String[]> readFile(String readFromFilePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(readFromFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(DELIMITER));
            }
        } catch (IOException e) {
            throw new RuntimeException("can't find file or read from this path: "
                    + readFromFilePath, e);
        }
        return data;
    }
}
