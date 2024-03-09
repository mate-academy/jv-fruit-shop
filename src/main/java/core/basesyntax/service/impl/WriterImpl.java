package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    @Override
    public void putDataToFile(String data, String pathToFile) {
        Path path = Path.of(pathToFile);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
