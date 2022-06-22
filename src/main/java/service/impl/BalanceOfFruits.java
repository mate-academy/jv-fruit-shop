package service.impl;

import dao.FruitsDao;
import model.FruitTransaction;
import service.FruitHandler;

public class BalanceOfFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public BalanceOfFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        fruitsDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
