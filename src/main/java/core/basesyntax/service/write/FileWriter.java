package core.basesyntax.service.write;

import java.nio.file.Path;

public interface FileWriter {
    void write(Path filePath, String data);
}
