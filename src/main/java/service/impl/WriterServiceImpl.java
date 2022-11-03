package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String fileName, String record) {
        try {
            Files.write(Path.of(fileName), record.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data in file " + fileName, e);
        }
    }
}
