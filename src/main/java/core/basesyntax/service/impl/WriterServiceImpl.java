package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(Path fileName, String report) {
        try {
            Files.write(fileName, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Error write report to file '%s'", fileName), e);
        }
    }
}
