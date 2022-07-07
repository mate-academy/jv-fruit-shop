package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String pathToFile, String report) {
        try {
            Files.writeString(Path.of(pathToFile), report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write file" + e);
        }
    }
}
