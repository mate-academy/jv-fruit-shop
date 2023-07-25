package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
