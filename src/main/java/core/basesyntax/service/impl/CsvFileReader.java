package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {

    @Override
    public List<String> getLinesFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file" + fileName, e);
        }
    }
}
