package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.service.ReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String[]> readFromFile(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can`t read from file: " + path);
        }
    }
}
