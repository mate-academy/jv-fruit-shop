package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

@FunctionalInterface
public interface OperationHandler {
    void process(Map<String, Integer> fruitQuantityMap, FruitTransaction transaction);
}
