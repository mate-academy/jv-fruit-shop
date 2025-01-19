package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        try {
            Path path = Paths.get("src", "main", "java", "resources", fileName);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName);
        }
    }
}
