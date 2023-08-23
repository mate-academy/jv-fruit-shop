package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionStrategy {
    FruitTransactionHandler getHandler(FruitTransaction fruitTransaction);
}
