package core.basesyntax.impl;

import core.basesyntax.service.ReadService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFromCsv implements ReadService {
    @Override
    public List<String> readFromFile(String path) {
        File fileToRead = new File(path);
        try {
            return Files.readAllLines(fileToRead.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file with path: " + fileToRead.getPath());
        }
    }
}
