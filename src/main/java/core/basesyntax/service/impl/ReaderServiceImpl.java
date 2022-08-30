package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        File fileReader = new File(fileName);
        List<String> line = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReader))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                line.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        return line;
    }
}
