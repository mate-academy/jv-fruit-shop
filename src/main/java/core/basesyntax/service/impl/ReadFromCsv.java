package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFromCsv implements CustomFileReader {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> readFile(String filePath) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.lines()
                    .skip(1)
                    .map(s -> {
                        String[] lineData = s.split(SEPARATOR);
                        return new FruitTransaction(
                                lineData[0], lineData[1], Integer.parseInt(lineData[2])); })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find this file " + filePath, e);
        }
    }
}
