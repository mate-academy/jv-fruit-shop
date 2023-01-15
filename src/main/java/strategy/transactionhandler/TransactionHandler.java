package strategy.transactionhandler;

import service.FruitTransaction;

public interface TransactionHandler {
    int operate(FruitTransaction fruitTransaction);
}
