package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public interface TransactionHandler {
    int perform(int amount, Transaction transaction);
}
