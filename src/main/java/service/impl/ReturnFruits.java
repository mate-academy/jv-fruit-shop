package service.impl;

import dao.FruitsDao;
import service.FruitHandler;

public class ReturnFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public ReturnFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(String fruit, int amount) {
        int amountFromStorage = fruitsDao.get(fruit);
        int newAmountOfStorage = amountFromStorage + amount;
        fruitsDao.remove(fruit);
        fruitsDao.add(fruit, newAmountOfStorage);
    }
}
