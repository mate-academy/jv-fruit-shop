package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction transaction);
}
