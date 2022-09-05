package service.strategy;

import model.Transaction;

public interface TransactionHandler {
    void apply(Transaction transaction);
}
