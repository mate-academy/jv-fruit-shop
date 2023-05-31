package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitHandlerStrategy {
    FruitHandler getOperationService(FruitTransaction.Operation operation);
}
