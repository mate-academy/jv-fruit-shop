package core.basesyntax.service_impl;

import core.basesyntax.service.Reader;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class CsvReaderImpl implements Reader {
    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + file.getName(), e);
        }
    }
}
