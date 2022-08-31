package core.basesyntax.service.impl;

import core.basesyntax.service.ContentReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ContentReaderImpl implements ContentReader {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName, e);
        }
    }
}
