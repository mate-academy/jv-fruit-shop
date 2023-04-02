package core.basesyntax.service.impl;

import core.basesyntax.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderImpl implements DataReader {
    @Override
    public List<String> read(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + path, e);
        }
    }
}
