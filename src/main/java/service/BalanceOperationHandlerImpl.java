package service;

import dao.FruitsDao;
import dao.FruitsDaoImpl;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void doOperation(String key, String value) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        fruitsDao.addProduct(key, Integer.parseInt(value));
    }
}
