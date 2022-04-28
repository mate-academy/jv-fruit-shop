package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> readFile(String inputData) {
        try {
            return Files.readAllLines(Paths.get(inputData));
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read this file", e);
        }
    }
}
