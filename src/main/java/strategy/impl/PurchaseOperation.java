package strategy.impl;

import dao.FruitDao;
import db.FruitStorage;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    public PurchaseOperation(FruitDao fruitDao) {
    }

    @Override
    public void handle(String fruit, int quantity) {
        int current = FruitStorage.fruits.getOrDefault(fruit, 0);
        if (current < quantity) {
            throw new RuntimeException("Not enough fruits!");
        }
        FruitStorage.fruits.put(fruit, current - quantity);
    }
}
