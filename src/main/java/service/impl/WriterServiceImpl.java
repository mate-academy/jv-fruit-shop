package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String filePath, String output) {
        try {
            Files.write(Path.of(filePath), output.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + output, e);
        }
    }
}
