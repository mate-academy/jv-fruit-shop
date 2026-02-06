package basesyntax.service.impl;

import basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath))
                    .stream()
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
    }
}
