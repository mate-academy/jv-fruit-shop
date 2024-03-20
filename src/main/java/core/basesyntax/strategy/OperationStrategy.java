package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    void handleTransaction(FruitTransaction transaction, Map<String, Integer> fruitStore);
}

