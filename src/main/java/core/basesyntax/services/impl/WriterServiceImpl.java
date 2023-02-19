package core.basesyntax.services.impl;

import core.basesyntax.services.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String date, String path) {
        try {
            Files.writeString(Path.of(path), date);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file" + path, e);
        }
    }
}
