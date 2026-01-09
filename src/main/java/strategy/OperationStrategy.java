package strategy;

import core.basesyntax.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler get(FruitTransaction.Operation operation);
}
