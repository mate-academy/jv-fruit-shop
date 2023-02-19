package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, String data) {
        try {
            Files.write(Paths.get(path), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
