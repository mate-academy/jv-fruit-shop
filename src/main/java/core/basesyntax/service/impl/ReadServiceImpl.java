package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadServiceImpl implements ReadService {

    @Override
    public List<String> readFromFile(String toFile) {
        File file = new File(toFile);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file " + file, e);
        }
    }
}
