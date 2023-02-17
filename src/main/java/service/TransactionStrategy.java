package service;

import model.FruitTransaction;
import service.transaction.TransactionHandler;

public interface TransactionStrategy {

    TransactionHandler get(FruitTransaction.Operation operation);
}
