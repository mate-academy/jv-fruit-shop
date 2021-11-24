package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, List<String> report) {
        try {
            Files.write(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file!", e);
        }
    }
}
