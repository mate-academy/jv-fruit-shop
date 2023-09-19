package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getByOperation(FruitTransaction.Operation operation);
}
