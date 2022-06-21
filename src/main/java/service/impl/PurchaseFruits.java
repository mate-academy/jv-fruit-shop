package service.impl;

import dao.FruitsDao;
import service.FruitHandler;

public class PurchaseFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public PurchaseFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(String fruit, int amount) {
        int amountFromStorage = fruitsDao.get(fruit);
        int newAmountFromStorage = amountFromStorage - amount;
        fruitsDao.add(fruit, newAmountFromStorage);
    }
}
