package core.basesyntax.strategy;

import java.util.Map;

public interface FruitOperationStrategy {
    void execute(Map<String, Integer> fruitQuantity, String fruit, int quantity);
}

