package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String data, String fileName) {
        try {
            Files.write(Path.of(fileName), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to " + fileName, e);
        }
    }
}
