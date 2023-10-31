package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderFileServiceImpl implements ReaderFileService {
    @Override
    public List<String> read(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Cant read file from " + path, e);
        }
    }
}
