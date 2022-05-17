package mate.academy.operation.impl;

import mate.academy.dao.FruitDao;
import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction);
    }
}
