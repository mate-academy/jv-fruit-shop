package core.basesyntax.service;

import core.basesyntax.model.FruitType;
import java.util.Map;

public interface Writer {
    void writeRepo(Map<FruitType, Integer> fruitServiceMap);
}
