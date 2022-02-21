package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FileWriterService {
    void writeToFile(String toFilePath, Map<Fruit, Integer> storage);
}
