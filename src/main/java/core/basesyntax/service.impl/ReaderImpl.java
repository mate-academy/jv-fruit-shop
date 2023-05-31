package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException o) {
            throw new RuntimeException("Can't read to file " + fileName);
        }
    }
}
