package core.basesyntax.strategy;

import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
