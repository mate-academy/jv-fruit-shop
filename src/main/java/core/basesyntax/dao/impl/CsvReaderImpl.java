package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderImpl implements FileReader {

    @Override
    public List<String> parse(String fileName) {
        try {
            return Files.readAllLines(Path.of(
                    "./src/main/java/core/basesyntax/resources/" + fileName
            ));
        } catch (IOException e) {
            throw new RuntimeException("cant read from file: " + fileName);
        }
    }
}
