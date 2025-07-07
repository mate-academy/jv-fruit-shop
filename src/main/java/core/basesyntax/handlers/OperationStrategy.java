package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
