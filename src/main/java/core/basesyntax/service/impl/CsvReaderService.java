package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CsvReaderService implements ReaderService {
    @Override
    public Stream<String> readFromFile(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Error: The file path is null!");
        }
        try {
            if (Files.lines(Paths.get(filePath)).findAny().isPresent()) {
                return Files.lines(Paths.get(filePath)).skip(1);
            } else {
                throw new RuntimeException("This file is empty");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read data from file", e);
        }
    }
}
