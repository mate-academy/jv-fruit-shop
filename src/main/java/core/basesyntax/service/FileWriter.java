package core.basesyntax.service;

import java.nio.file.Path;

public interface FileWriter {
    void write(String report, Path filePath);
}
