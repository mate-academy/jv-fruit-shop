package service.transaction;

import model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
