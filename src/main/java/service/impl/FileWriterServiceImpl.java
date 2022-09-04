package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeDataToFile(String filename, String report) {
        try {
            Files.createFile(Paths.get(filename));
            Files.writeString(Path.of(filename), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filename, e);
        }
    }
}
