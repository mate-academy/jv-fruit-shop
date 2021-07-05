package core.basesyntax.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCsvWriter implements Writer {
    @Override
    public boolean write(String report, String path) {
        try {
            if (!Files.exists(Path.of(path))) {
                Files.createFile(Path.of(path));
            }
            Files.write(Path.of(path),report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("There is a problem with saving", e);
        }
        return true;
    }
}

