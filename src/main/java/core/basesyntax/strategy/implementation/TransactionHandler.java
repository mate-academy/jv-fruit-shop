package core.basesyntax.strategy.implementation;

import core.basesyntax.models.Transaction;

public interface TransactionHandler {
    boolean handleTransaction(Transaction transaction);
}
