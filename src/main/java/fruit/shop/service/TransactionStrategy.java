package fruit.shop.service;

import fruit.shop.model.FruitTransaction;

public interface TransactionStrategy {
    void executeTransactionHandler(FruitTransaction transaction);
}
