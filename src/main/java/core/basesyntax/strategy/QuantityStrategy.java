package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    QuantityHandler getQuantityHandler(FruitTransaction.Operation operation);
}
