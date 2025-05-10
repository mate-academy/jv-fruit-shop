package core.basesyntax.operation.operationstrategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
