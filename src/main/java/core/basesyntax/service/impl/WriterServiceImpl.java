package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String PATH = "src/main/resources/report";

    @Override
    public void write(List<String> report) {
        Path path = Path.of(PATH);
        try {
            Files.write(path,report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
