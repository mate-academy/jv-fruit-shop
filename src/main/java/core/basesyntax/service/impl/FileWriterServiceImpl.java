package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, String fileToPath) {
        Path path = Path.of(fileToPath);
        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileToPath, e);
        }
    }
}
