package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements FileReaderService {
    private static final String FILE_PATH = "./src/main/resources/input-file.csv";

    @Override
    public List<String> read() {
        List<String> statistic = new ArrayList<>();
        try (BufferedReader reader
                     = new BufferedReader(new FileReader(FILE_PATH));) {
            String value = reader.readLine();
            while (value != null) {
                statistic.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return statistic;
    }
}
