package core.basesyntax.service.fileservices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    public void writeData(String data, String outputPath) {
        try {
            Files.writeString(Path.of(outputPath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + outputPath, e);
        }
    }
}
