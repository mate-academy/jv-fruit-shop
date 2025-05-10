package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
