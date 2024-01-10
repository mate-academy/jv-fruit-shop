package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderOwn;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

public class FileReaderImpl implements FileReaderOwn {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new NoSuchElementException("No file found for this path: " + filePath, e);
        }
    }
}
