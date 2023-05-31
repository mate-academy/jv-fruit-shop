package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitStrategy {
    OperationsStrategy get(FruitTransaction.Operation operation);
}
