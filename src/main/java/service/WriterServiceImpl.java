package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean write(String transactions, Path path) {
        try {
            Files.writeString(path, transactions);
        } catch (IOException e) {
            throw new RuntimeException("Can't write transactions to file", e);
        }
        return true;
    }
}
