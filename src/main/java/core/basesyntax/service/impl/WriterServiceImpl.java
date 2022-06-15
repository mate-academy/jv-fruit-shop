package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeFile(String data, String fileName) {
        Path filePath = Path.of(fileName);
        try {
            Files.createFile(filePath);
            Files.write(filePath, data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + fileName, e);
        }
    }
}
