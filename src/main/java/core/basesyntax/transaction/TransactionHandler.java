package core.basesyntax.transaction;

import core.basesyntax.model.Fruit;

public interface TransactionHandler {
    Fruit callTransaction(Fruit fruit, int amount);
}
