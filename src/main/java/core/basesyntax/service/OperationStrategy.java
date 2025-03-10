package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
