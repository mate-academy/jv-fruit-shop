package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int COLUMN_NAMES_INDEX = 0;

    @Override
    public List<String[]> readFromFile(String path) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + path, e);
        }
        data.remove(COLUMN_NAMES_INDEX);
        return data;
    }
}
