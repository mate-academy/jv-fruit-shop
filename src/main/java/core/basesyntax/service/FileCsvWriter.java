package core.basesyntax.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCsvWriter implements Writer {
    @Override
    public boolean writeToFile(String report, String filePath) {
        try {
            if (!Files.exists(Path.of(filePath))) {
                Files.createFile(Path.of(filePath));
            }
            Files.write(Path.of(filePath),report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("There is a problem with saving" + filePath, e);
        }
        return true;
    }
}

