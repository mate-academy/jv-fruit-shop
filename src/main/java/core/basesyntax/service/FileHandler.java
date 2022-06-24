package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileHandler {
    List<String> readFile(Path filePath);

    void writeCsv(List<String> data, Path toFile);
}
