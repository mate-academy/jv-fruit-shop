package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler getHandler(FruitTransaction.Operation operation);
}
