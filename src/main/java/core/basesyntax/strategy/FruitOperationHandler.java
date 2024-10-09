package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitOperationHandler {
    void executeOperation(FruitTransaction transaction, Map<String, Integer> inventory);
}
