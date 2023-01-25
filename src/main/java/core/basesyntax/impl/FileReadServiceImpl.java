package core.basesyntax.impl;

import core.basesyntax.services.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> readFromFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Couldn`t get data from file by path " + path, e);
        }
    }
}
