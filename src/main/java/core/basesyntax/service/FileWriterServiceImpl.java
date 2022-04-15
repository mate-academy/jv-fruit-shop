package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String report, String fileName) {
        try {
            Files.write(Path.of(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to " + fileName, e);
        }
    }
}
