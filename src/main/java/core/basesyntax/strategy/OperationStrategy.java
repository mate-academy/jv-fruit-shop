package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getByOperation(FruitTransaction.Operation operation);
}