package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, Path path) {
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file");
        }
    }
}
