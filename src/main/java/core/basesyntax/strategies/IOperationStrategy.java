package core.basesyntax.strategies;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operationHandler.IOperationHandler;

public interface IOperationStrategy {
    IOperationHandler get(FruitTransaction.Operation operation);
}
