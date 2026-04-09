package strategy.impl;

import dao.FruitDao;
import db.FruitStorage;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    public ReturnOperation(FruitDao fruitDao) {
    }

    @Override
    public void handle(String fruit, int quantity) {
        FruitStorage.fruits.merge(fruit, quantity, Integer::sum);
    }
}
