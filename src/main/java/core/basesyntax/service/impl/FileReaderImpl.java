package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<List<String>> getData(String fromFileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFileName))) {
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
