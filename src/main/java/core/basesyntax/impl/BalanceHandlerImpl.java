package core.basesyntax.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
