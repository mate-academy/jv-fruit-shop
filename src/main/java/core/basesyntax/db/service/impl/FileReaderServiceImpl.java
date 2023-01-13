package core.basesyntax.db.service.impl;

import core.basesyntax.db.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
            lines.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path, e);
        }
        return lines;
    }
}
