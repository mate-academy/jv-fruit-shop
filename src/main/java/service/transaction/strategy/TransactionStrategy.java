package service.transaction.strategy;

import model.Transaction;
import service.transaction.strategy.type.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(Transaction.Type type);
}

