package core.basesyntax.service;

import java.nio.file.Path;

public interface FileWriter {
    void write(Path destination, String content);
}
