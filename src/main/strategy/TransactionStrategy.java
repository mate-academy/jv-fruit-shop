package main.strategy;

import main.model.Transaction;
import main.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(Transaction transaction);
}
