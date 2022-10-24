package core.basesyntax.service.impl;

import core.basesyntax.service.FileLinesReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLinesReaderServiceImpl implements FileLinesReaderService {
    @Override
    public List<String> readFile(String path) {
        Path pathToInput = Path.of(path);
        try {
            return Files.readAllLines(pathToInput);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: "
                    + path, e);
        }
    }
}
