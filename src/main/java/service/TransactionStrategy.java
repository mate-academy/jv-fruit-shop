package service;

import model.FruitTransaction;
import service.activities.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler getHandler(FruitTransaction.Operation operation);
}
