package core.basesyntax.services.impl;

import core.basesyntax.services.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class CsvReaderImpl implements FileReader {

    @Override
    public String read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            return bufferedReader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path, e);
        }
    }
}
