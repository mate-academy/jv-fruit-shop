package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String path) {
        List<String> infoFromFile;
        try {
            infoFromFile = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file" + path, e);
        }
        return infoFromFile;
    }
}
