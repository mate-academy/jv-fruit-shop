package core.basesyntax.services.impl;

import core.basesyntax.services.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Cant read from file");
        }
    }
}
