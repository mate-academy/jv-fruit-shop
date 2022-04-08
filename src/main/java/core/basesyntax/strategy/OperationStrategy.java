package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void process(FruitTransaction.Operation operation, String fruit, Integer quantity);
}
