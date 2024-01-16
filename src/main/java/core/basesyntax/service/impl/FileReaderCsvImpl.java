package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderCsvImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> allLines = Files.readAllLines(path);
            return allLines.subList(1, allLines.size());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}

