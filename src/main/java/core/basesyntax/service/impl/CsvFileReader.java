package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> readLines;
        Path path = Path.of(filePath);
        try {
            readLines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file "
                    + path.getFileName(), e);
        }
        if (readLines.isEmpty()) {
            throw new RuntimeException("Input file can not be empty: "
                    + path.getFileName());
        }
        return readLines;
    }
}
