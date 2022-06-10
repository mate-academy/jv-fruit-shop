package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface QuantityStrategy {
    OperationHandler getQuantityHandler(FruitTransaction.Operation operation);
}
