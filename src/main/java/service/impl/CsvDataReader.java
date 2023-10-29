package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class CsvDataReader implements ReaderService {
    public static final String SEPARATOR = ",";

    @Override
    public List<String[]> readFromFile(String filePath) {
        final List<String[]> records = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            lines.forEach(line -> records.add(line.split(SEPARATOR)));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file "
                    + filePath + " !", e);
        }
        return records;
    }
}
