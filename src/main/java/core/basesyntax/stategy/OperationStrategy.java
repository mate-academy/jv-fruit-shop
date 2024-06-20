package core.basesyntax.stategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
