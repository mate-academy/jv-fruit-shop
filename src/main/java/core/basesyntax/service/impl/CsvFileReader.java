package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader<String> {
    @Override
    public List<String> parseDataFrom(String fileName) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the File: " + fileName, e);
        }
        return strings;
    }
}
