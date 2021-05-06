package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServiceWriterImpl implements ServiceWriter {
    private static final String COMMA = ",";

    @Override
    public void writeData(String data, String filePath) {
        Path path = Path.of(filePath);
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + filePath, e);
        }
    }
}
