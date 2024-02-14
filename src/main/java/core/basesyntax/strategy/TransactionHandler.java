package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    TransactionStrategy makeTransaction(FruitTransaction transaction);
}

