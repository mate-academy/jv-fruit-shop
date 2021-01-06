package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readFromFile(String filePathFrom) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(filePathFrom)));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePathFrom);
        }
    }
}
