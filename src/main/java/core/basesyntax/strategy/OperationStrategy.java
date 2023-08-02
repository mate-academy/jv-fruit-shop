package core.basesyntax.strategy;

import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.OperationType operation);
}
