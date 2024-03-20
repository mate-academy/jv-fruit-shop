package core.basesyntax.service;

import java.nio.file.Path;

public interface FruitService {

    void processCsvFile(Path fromFile, Path toFile);
}
