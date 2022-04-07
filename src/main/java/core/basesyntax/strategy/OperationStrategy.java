package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void activity(FruitTransaction.Operation operation, String fruit, Integer quantity);
}
