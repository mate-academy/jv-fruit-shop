package service;

import dao.FruitsDao;
import dao.FruitsDaoImpl;
import model.Fruit;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public PurchaseOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit key, String value) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        fruitsDao.addProduct(key, fruitsDao.getValue(key) - Integer.parseInt(value));
    }
}
