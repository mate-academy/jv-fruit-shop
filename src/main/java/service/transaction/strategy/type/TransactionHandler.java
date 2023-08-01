package service.transaction.strategy.type;

import model.Transaction;

public interface TransactionHandler {
    void perform(Transaction transaction);
}
