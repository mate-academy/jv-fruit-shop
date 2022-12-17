package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean write(String dataToFile, String path) {
        try {
            Files.writeString(Paths.get(path), dataToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't write transactions to file", e);
        }
        return true;
    }
}
