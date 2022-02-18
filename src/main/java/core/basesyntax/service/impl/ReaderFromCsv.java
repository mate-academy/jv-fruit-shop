package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromCsv implements Reader {
    @Override
    public List<String> readData(String fromFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            return bufferedReader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + fromFile, e);
        }
    }
}
