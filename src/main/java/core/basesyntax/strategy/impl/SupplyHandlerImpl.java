package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int quantityBefore = fruitDao.get(transaction.getFruit());
        fruitDao.add(transaction.getFruit(), quantityBefore + transaction.getQuantity());
    }
}
