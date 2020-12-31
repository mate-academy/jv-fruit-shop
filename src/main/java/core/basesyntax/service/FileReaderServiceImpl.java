package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {
    private String filePath;

    public FileReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + filePath, e);
        }
    }
}
