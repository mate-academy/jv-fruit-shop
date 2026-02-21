package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements WriterService {
    @Override
    public void write(String report, String filePath) {
        if (filePath == null) {
            throw new RuntimeException("Path to file can't be null");
        }
        if (report == null || report.isEmpty()) {
            throw new RuntimeException("Report string can't be null or empty");
        }
        try {
            Files.write(Path.of(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
