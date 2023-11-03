package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandlers;

public interface OperationStrategy {
    OperationHandlers getHandler(FruitTransaction.Operation operation);
}
