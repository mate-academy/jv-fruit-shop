package service.impl;

import dao.FruitsDao;
import service.FruitHandler;

public class BalanceOfFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public BalanceOfFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(String fruit, int amount) {
        fruitsDao.add(fruit, amount);
    }
}
