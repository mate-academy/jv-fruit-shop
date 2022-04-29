package core.basesyntax.service;

import java.nio.file.Path;

public interface FileWriterService {
    void write(Path path, String report);
}
