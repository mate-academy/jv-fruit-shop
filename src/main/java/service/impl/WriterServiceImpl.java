package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String data, String toFile) {
        try {
            Files.write(Path.of(toFile), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data " + data + "to file" + toFile);
        }
    }
}
