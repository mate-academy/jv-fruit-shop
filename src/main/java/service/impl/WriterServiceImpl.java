package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(Path path, String string) {
        try {
            Files.writeString(path, string);
        } catch (IOException e) {
            throw new RuntimeException("Can't writ to file: " + path, e);
        }
    }
}
