package service.impl;

import dao.FruitsDao;
import service.FruitHandler;

public class SupplyFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public SupplyFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(String fruit, int amount) {
        int amountFromStorage = fruitsDao.get(fruit);
        int newAmountOfStorage = amountFromStorage + amount;
        fruitsDao.add(fruit, newAmountOfStorage);
    }
}
