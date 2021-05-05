package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriterService {

    @Override
    public void write(String report, String filepath) {
        try {
            Files.write(Path.of(filepath), report.getBytes());
        } catch (Exception exception) {
            throw new RuntimeException("Can't write to file " + filepath, exception);
        }
    }
}
