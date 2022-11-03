package strategy.impl;

import db.ShopStorage;
import strategy.TransactionHandler;

public class TransactionHandlerImpl implements TransactionHandler {

    @Override
    public void addToBalance(String fruit, Integer quantity) {
        if (!ShopStorage.fruitsStorage.containsKey(fruit)) {
            ShopStorage.fruitsStorage.put(fruit, quantity);
        } else {
            ShopStorage.fruitsStorage
                    .replace(fruit, ShopStorage.fruitsStorage.get(fruit) + quantity);
        }
    }

    @Override
    public void takeFromBalance(String fruit, Integer quantity) {
        if (!ShopStorage.fruitsStorage.containsKey(fruit)) {
            ShopStorage.fruitsStorage.put(fruit, -quantity);
        } else {
            ShopStorage.fruitsStorage
                    .replace(fruit, ShopStorage.fruitsStorage.get(fruit) - quantity);
        }
    }
}
