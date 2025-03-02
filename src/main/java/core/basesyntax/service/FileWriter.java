package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Path;

public interface FileWriter {
    void write(String report, Path filePath) throws IOException;
}
