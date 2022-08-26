package handler.impl;

import dao.FruitDao;
import handler.OperationHandler;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        fruitDao.update(fruit,
                fruitDao.getQuantity(fruit) + fruitTransaction.getQuantity());
    }
}
