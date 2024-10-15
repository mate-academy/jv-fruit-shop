package core.basesyntax.operation;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
