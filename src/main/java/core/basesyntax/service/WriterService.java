package core.basesyntax.service;

import java.nio.file.Path;

public interface WriterService {
    void write(Path fileName, String report);
}
