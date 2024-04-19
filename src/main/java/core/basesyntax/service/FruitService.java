package core.basesyntax.service;

import java.nio.file.Path;

public interface FruitService {
    void countToCsv(Path fromFile, Path toFile);
}
