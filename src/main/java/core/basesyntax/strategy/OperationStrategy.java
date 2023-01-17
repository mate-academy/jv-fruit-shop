package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationCalculator getOperationHandler(FruitTransaction.Operation operation);
}
