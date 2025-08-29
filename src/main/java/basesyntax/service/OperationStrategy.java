package basesyntax.service;

import basesyntax.common.FruitTransaction;
import basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
