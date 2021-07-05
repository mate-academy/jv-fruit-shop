package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileCsvReader implements Reader {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName))
                .stream()
                .skip(1)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Problem with file",e);
        }
    }
}

