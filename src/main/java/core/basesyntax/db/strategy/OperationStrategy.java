package core.basesyntax.db.strategy;

import core.basesyntax.db.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
