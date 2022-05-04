package service.implementations;

import dao.FruitsDao;
import model.Fruit;
import service.inerfaces.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public SupplyOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        fruitsDao.addProduct(fruit, quantity + fruitsDao.getValue(fruit));
    }
}
