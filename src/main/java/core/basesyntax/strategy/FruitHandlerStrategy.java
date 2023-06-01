package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitHandlerStrategy {
    FruitHandler getHandler(FruitTransaction.Operation operation);
}
