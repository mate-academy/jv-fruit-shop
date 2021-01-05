package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String[]> readFromFile(String filePathFrom) {
        try {
            return Files.readAllLines(Path.of(filePathFrom)).stream()
                    .map(l -> l.split(","))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePathFrom);
        }
    }
}
