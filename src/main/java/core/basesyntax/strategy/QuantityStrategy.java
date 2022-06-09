package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface QuantityStrategy {
    QuantityHandler getQuantityHandler(FruitTransaction.Operation operation);
}
