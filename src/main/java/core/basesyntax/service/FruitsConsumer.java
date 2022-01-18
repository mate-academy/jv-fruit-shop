package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitsConsumer {
    void accept(Map<Fruit, Integer> fruitMap);
}
