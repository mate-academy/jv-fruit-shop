package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
