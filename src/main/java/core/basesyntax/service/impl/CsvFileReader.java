package core.basesyntax.service.impl;

import static java.nio.file.Path.of;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements Reader {
    @Override
    public List<String[]> read(String fromFilePath) {
        List<String[]> dataFromDb = new ArrayList<>();
        try {
            Files.readAllLines(of(fromFilePath)).stream()
                    .skip(1)
                    .forEach(line -> dataFromDb.add(line.split(",")));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fromFilePath, e);
        }
        return dataFromDb;
    }
}
