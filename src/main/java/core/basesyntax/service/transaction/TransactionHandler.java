package core.basesyntax.service.transaction;

import core.basesyntax.model.Transaction;

public interface TransactionHandler {
    void makeTransaction(Transaction transaction);
}
