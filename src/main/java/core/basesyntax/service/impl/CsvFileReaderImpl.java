package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file \"" + filePath + "\"", e);
        }
        return lines;
    }
}
