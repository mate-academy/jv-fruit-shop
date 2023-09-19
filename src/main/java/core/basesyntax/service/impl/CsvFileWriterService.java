package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterService implements FileWriterService {
    @Override
    public void writeToFile(String filePath, String output) {
        Path path = Path.of(filePath);
        try {
            Files.write(path, output.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
