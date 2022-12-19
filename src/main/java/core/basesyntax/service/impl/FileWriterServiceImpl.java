package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(Path path, String report) {
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + path, e);
        }
    }
}
