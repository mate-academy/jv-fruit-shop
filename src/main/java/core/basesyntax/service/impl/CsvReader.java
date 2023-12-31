package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReader implements Reader {
    @Override
    public List<String> readFile(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(new File(pathToFile).toURI()));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + pathToFile);
        }
    }
}
