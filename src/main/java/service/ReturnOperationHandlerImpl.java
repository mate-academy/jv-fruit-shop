package service;

import dao.FruitsDao;
import dao.FruitsDaoImpl;

public class ReturnOperationHandlerImpl implements OperationHandler {

    @Override
    public void doOperation(String key, String value) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        fruitsDao.addProduct(key, fruitsDao.getValue(key) + Integer.parseInt(value));
    }
}
