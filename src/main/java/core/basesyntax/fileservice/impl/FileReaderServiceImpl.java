package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> readLines = new ArrayList<>();
        try {
            readLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from file with path: " + path, e);
        }
        return readLines;
    }
}
