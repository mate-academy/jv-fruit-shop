package service.strategy;

import model.Transaction;

public interface TransactionHandler {
    void execute(Transaction transaction);
}
