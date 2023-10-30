package service.transaction.strategy;

import model.FruitTransaction;
import service.transaction.strategy.type.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction.OperationType type);
}

