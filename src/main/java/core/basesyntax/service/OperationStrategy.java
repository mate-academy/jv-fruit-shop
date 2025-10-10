package core.basesyntax.service;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
