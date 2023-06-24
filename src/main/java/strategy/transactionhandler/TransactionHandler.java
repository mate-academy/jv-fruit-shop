package strategy.transactionhandler;

import service.FruitTransaction;

public interface TransactionHandler {
    void operate(FruitTransaction fruitTransaction);
}
