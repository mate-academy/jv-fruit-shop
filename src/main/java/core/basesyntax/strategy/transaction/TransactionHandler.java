package core.basesyntax.strategy.transaction;

import core.basesyntax.model.Fruit;

public interface TransactionHandler {
    int getTransaction(Fruit fruit, int quantity);
}
