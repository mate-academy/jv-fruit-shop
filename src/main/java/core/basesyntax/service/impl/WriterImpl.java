package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    @Override
    public void write(String report, String path) {
        Path filePath = Path.of(path);
        try {
            Files.writeString(filePath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to: " + path, e);
        }
    }
}
