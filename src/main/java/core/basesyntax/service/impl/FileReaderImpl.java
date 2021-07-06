package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> read(String fileName) {
        try {
            Path path = Path.of(fileName);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file! Filename - " + fileName
                    + ", exception - ", e);
        }
    }
}
