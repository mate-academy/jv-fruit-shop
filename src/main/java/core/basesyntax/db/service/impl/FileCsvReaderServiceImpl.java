package core.basesyntax.db.service.impl;

import core.basesyntax.db.service.FileCsvReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileCsvReaderServiceImpl implements FileCsvReaderService {
    @Override
    public List<String> readFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path, e);
        }
    }
}
