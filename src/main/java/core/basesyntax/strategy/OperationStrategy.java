package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.Handler;

public interface OperationStrategy {
    public Handler get(FruitTransaction.Operation operation);
}
