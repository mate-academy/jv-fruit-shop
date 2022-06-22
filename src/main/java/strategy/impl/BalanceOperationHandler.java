package strategy.impl;

import dao.FruitsDao;
import model.FruitTransaction;
import strategy.FruitHandler;

public class BalanceOperationHandler implements FruitHandler {
    private FruitsDao fruitsDao;

    public BalanceOperationHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        fruitsDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
