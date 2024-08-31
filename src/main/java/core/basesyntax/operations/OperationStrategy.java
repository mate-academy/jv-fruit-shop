package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
