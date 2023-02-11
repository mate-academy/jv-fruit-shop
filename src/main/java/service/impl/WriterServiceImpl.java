package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    @Override
    public void writeToFile(String data) {
        try {
            Files.writeString(Path.of(OUTPUT_FILE_PATH), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + OUTPUT_FILE_PATH, e);
        }
    }
}
