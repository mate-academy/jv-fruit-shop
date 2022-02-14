package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReaderImpl implements DataReader {

    @Override
    public List<String> readData(String fileName) {
        List<String> data;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            data = bufferedReader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file: " + fileName, e);
        }
        return data;
    }
}
