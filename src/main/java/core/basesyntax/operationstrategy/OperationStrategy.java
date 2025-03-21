package core.basesyntax.operationstrategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationservice.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
