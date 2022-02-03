package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.basesyntax.service.DataReader;

public class DataReaderFromFile implements DataReader {

    @Override
    public List<List<String>> getData(String fromFileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            reader.lines().skip(1)
                    .forEachOrdered(line -> {
                        String[] values = line.split(",");
                        records.add(Arrays.asList(values));
                    });
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file by path: " + fromFileName, e);
        }
        return records;
    }
}
