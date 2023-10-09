package service.activities;

import model.FruitTransaction;

public interface TransactionHandler {
    //викон операцію і записати в fruitShop
    void executeTransaction(FruitTransaction fruitTransaction);
}
