package core.basesyntax.db.service.impl;

import core.basesyntax.db.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, String path) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
