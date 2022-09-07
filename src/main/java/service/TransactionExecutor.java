package service;

import model.Transaction;

public interface TransactionExecutor {
    void execute(Transaction transaction);
}
