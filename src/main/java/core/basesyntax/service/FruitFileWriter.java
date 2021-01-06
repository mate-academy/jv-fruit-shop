package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitFileWriter {
    void writeToFile(Map<Fruit, Integer> base, String filePath);
}
