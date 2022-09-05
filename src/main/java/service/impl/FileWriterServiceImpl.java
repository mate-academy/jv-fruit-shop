package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String filename, String report) {
        try {
            Files.write(Path.of(filename), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filename, e);
        }
    }
}
