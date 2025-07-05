package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    QuantityCalculationStrategy get(FruitTransaction.Operation operation);
}
