package handler.impl;

import dao.FruitDao;
import handler.OperationHandler;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
