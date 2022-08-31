package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements Reader {
    @Override
    public List<String> read(String fromFile) {
        try {
            return Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fromFile, e);
        }
    }
}
