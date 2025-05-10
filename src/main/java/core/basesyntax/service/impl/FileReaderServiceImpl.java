package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String row;
            reader.readLine();
            while ((row = reader.readLine()) != null) {
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file " + filePath, e);
        }
        return data;
    }
}
