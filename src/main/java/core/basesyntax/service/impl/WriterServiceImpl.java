package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String writePath, List<String> data) {
        Path path = Paths.get(writePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + writePath);
        }
    }
}
