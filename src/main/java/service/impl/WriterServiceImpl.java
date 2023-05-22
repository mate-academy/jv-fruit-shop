package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file " + filePath, e);
        }
    }
}
