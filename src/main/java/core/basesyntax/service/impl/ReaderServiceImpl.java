package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import core.basesyntax.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String HEADER = "type";

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String row;
            while ((row = reader.readLine()) != null) {
                if (row.contains(HEADER)) {
                    continue;
                }
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file " + filePath, e);
        }
        return data;
    }
}
