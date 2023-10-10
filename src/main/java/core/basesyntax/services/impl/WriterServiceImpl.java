package core.basesyntax.services.impl;

import core.basesyntax.services.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean writeToFile(String fileName, String report) {
        Path path = Paths.get(fileName);
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
        return true;
    }
}
