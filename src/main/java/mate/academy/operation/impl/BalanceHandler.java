package mate.academy.operation.impl;

import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction);
    }
}
