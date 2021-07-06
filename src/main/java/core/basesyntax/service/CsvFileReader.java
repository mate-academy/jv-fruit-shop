package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName))
                .stream()
                .skip(1)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Problem with file" + fileName, e);
        }
    }
}

