package strategy.impl;

import dao.FruitDao;
import db.FruitStorage;
import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    public BalanceOperation(FruitDao fruitDao) {

    }

    @Override
    public void handle(String fruit, int quantity) {
        FruitStorage.fruits.put(fruit, quantity);
    }
}
