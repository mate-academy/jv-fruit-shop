package core.basesyntax.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int quantityBefore = fruitDao.get(transaction.getFruit());
        fruitDao.add(transaction.getFruit(), quantityBefore + transaction.getQuantity());
    }
}
