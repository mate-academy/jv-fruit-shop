package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface WorkerWithTransactions {
    void completeTransaction(Transaction transaction);
}
