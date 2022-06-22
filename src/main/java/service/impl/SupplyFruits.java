package service.impl;

import dao.FruitsDao;
import model.FruitTransaction;
import service.FruitHandler;

public class SupplyFruits implements FruitHandler {
    private FruitsDao fruitsDao;

    public SupplyFruits(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int amountFromStorage = fruitsDao.get(transaction.getFruit());
        int newAmountOfStorage = amountFromStorage + transaction.getQuantity();
        fruitsDao.add(transaction.getFruit(), newAmountOfStorage);
    }
}
