package core.basesyntax.service;

import java.nio.file.Path;

public interface WriterService {
    void writeToFile(String report, Path path);
}
