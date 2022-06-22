package strategy.impl;

import dao.FruitsDao;
import model.FruitTransaction;
import strategy.FruitHandler;

public class ReturnOperationHandler implements FruitHandler {
    private FruitsDao fruitsDao;

    public ReturnOperationHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        int amountFromStorage = fruitsDao.get(transaction.getFruit());
        int newAmountOfStorage = amountFromStorage + transaction.getQuantity();
        fruitsDao.add(transaction.getFruit(), newAmountOfStorage);
    }
}
