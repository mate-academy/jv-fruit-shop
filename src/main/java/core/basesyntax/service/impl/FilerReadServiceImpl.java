package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilerReadServiceImpl implements FileReadService {

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
    }
}

