package service.implementations;

import dao.FruitsDao;
import model.Fruit;
import service.inerfaces.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public ReturnOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit key, String value) {
        fruitsDao.addProduct(key, fruitsDao.getValue(key) + Integer.parseInt(value));
    }
}
