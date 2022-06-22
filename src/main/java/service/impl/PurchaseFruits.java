package service.impl;

import dao.FruitsDao;
import model.FruitTransaction;
import service.FruitHandler;

public class PurchaseFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public PurchaseFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int amountFromStorage = fruitsDao.get(transaction.getFruit());
        int newAmountFromStorage = amountFromStorage - transaction.getQuantity();
        fruitsDao.add(transaction.getFruit(), newAmountFromStorage);
    }
}
