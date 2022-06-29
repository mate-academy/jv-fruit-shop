package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> getDataFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName);
        }
    }
}
