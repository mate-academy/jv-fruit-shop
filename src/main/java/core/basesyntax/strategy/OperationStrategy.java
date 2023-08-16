package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationActivity get(FruitTransaction.Operation operation);
}
