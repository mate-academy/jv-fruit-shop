package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
