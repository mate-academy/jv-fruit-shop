package core.basesyntax.service;

import java.nio.file.Path;

public interface WriterService {
    void write(String report, Path path);
}
