package service.write.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import service.write.WriterService;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String pathToFile, String filename, String report) {
        File file = new File(pathToFile + filename);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file);
        }
    }
}
