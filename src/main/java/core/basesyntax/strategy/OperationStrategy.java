package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandle;

public interface OperationStrategy {
    public OperationHandle get(FruitTransaction.Operation operation);
}
