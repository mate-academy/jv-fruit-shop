package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String content) {
        try {
            Files.writeString(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException("Error when writing to file " + filePath, e);
        }
    }
}
