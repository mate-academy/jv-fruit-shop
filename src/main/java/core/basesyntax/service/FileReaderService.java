package core.basesyntax.service;

import java.nio.file.Path;

public interface FileReaderService {
    String readFromFile(Path path);
}
