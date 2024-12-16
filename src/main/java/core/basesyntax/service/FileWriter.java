package core.basesyntax.service;

import java.nio.file.Path;

public interface FileWriter {
    Boolean write(String report, Path filePath);
}
