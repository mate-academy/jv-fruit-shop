package core.basesyntax.service;

import java.nio.file.Path;

public interface WriteFileService {
    void writeToFile(Path path, String data);
}
