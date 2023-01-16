package core.basesyntax.service;

import java.nio.file.Path;

public interface FileWriteService {
    void writeToFile(Path path, String data);
}
