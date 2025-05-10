package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface QuantityIncrementer {
    void incrementByQuantity(Map<String, Integer> fruitQuantityMap, FruitTransaction transaction);
}
