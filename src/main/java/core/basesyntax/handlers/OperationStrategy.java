package core.basesyntax.handlers;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
