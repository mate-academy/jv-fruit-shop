package main.service.impl;

import main.service.interfaces.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String WRITE_FAILED = "Can't write to a file ";

    @Override
    public void writeData(String data, String filePath) {
        Path path = Path.of(filePath);
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException(WRITE_FAILED + filePath);
        }
    }
}
