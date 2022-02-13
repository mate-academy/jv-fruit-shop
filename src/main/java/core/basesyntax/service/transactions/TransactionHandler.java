package core.basesyntax.service.transactions;

import core.basesyntax.model.Transaction;

public interface TransactionHandler {
    void processTransaction(Transaction transaction);
}
