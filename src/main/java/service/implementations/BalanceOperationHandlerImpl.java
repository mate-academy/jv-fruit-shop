package service.implementations;

import dao.FruitsDao;
import model.Fruit;
import service.inerfaces.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperationHandlerImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        fruitsDao.addProduct(fruit, quantity);
    }
}
