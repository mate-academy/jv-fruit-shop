package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String path) {
        try {
            return Files
                    .lines(Path.of(path))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + path, e);
        }
    }
}
