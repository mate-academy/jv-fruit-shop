package core.basesyntax.service;

import core.basesyntax.transaction.TransactionHandler;

public interface TransactionService {
    void handleTransaction(TransactionHandler transactionHandler, String fruitName, int amount);
}
