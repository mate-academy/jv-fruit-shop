package strategy;

import model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction transaction);
}
