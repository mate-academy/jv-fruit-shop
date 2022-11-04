package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterToCsvService implements WriterService {
    @Override
    public void createReportAfterDay(String fileName, String data) {
        try {
            Files.write(Path.of(fileName), data
                    .getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
