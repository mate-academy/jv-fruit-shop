package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {

    public List<String> readDataFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        return lines;
    }
}
