package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationType {
    void revisionOperation(FruitTransaction transaction);
}
