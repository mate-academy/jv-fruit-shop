package core.basesyntax.service.impl;

import core.basesyntax.service.CsvReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements CsvReaderService {
    @Override
    public List<String> readFromFile(String fromFile) {
        File file = new File(fromFile);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("File not found or not a valid file: " + fromFile);
        }
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                list.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + fromFile, e);
        }
        return list;
    }
}
