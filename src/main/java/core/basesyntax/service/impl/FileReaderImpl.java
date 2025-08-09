package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file from path: " + filePath, e);
        }
    }
}
