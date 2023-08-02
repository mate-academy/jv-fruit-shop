package core.basesyntax.impl;

import core.basesyntax.service.ReadFileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFileFromCsv implements ReadFileService {
    @Override
    public List<String> readFromFile(String path) {
        try {
            File fileToRead = new File(path);
            return Files.readAllLines(fileToRead.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file with path: " + path, e);
        }
    }
}
