package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try {
            Files.write(Path.of(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write date to file", e);
        }
    }
}
