package strategy.transactionhandlers;

import model.FruitTransaction;

public interface TransactionHandler {
    void transaction(FruitTransaction transaction);
}
