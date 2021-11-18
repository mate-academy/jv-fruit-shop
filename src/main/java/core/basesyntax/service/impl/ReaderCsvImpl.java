package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    @Override
    public List<String> readFile(String inputFilePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(inputFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + inputFilePath, e);
        }
        return lines;
    }
}
