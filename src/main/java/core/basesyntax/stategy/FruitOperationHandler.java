package core.basesyntax.stategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitOperationHandler {
    void executeOperation(FruitTransaction fruitTransaction, Map<String, Integer> inventory);
}
