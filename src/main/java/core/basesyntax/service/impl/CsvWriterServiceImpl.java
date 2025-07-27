package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvWriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String data) {
        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
