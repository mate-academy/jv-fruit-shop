package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReading {
    List<String> readFromFile(Path path);
}
