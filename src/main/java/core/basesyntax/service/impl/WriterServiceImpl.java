package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(List<String> report) {
        try {
            Files.write(Path.of("src/main/resources/report"),report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
