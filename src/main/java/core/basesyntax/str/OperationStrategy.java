package core.basesyntax.str;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
