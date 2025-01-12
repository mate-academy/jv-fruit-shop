package core.basesyntax.model.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.handler.OperationHandler;

public interface OperationStrategy {
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
