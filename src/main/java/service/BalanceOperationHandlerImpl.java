package service;

import dao.FruitsDao;
import dao.FruitsDaoImpl;
import model.Fruit;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit key, String value) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        fruitsDao.addProduct(key, Integer.parseInt(value));
    }
}
