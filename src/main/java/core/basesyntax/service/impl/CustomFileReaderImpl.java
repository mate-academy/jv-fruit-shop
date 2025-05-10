package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
    @Override
    public List<String> read(String path) throws IOException {
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty.");
        }

        List<String> operations;
        try {
            operations = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new IOException("Can't read file at: " + path, e);
        }

        if (operations.size() <= 1) {
            return Collections.emptyList();
        }

        return operations.subList(1, operations.size());
    }

}
