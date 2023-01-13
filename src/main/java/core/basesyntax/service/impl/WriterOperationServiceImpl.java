package core.basesyntax.service.impl;

import core.basesyntax.service.WriterOperationService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterOperationServiceImpl implements WriterOperationService {
    @Override
    public void writeData(String report, String toFile) {
        try {
            Files.writeString(Path.of(toFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file",e);
        }
    }
}
