package service.implementations;

import dao.FruitsDao;
import model.Fruit;
import service.inerfaces.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public PurchaseOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        fruitsDao.addProduct(fruit, fruitsDao.getValue(fruit) - quantity);
    }
}
