package core.basesyntax.service;

import java.nio.file.Path;

public interface FruitFileWriter {
    void writeToFile(String data, Path filePath);
}
