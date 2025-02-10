package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
