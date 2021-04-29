package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.interfaces.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void fileWriteTo(String report, String path) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException exception) {
            throw new RuntimeException("Cant write Report to File", exception);
        }
    }
}
