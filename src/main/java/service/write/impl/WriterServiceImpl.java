package service.write.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.write.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String pathToFile, String filename, String report) {
        try {
            Files.write(Path.of(pathToFile, filename), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile + filename);
        }
    }
}
