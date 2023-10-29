package core.basesyntax.model.service.impl;

import core.basesyntax.model.exception.InvalidDataException;
import core.basesyntax.model.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReport(String filePath, String report) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new InvalidDataException("Can't find file by path: " + filePath);
        }
    }
}
