package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceCsvImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> readDate = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String value = reader.readLine();
            value = reader.readLine();
            while (value != null) {
                readDate.add(value);
                value = reader.readLine();
            }
            return readDate;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
