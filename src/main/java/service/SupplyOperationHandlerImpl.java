package service;

import dao.FruitsDao;
import model.Fruit;

public class SupplyOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public SupplyOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit key, String value) {
        fruitsDao.addProduct(key, Integer.parseInt(value) + fruitsDao.getValue(key));
    }
}
