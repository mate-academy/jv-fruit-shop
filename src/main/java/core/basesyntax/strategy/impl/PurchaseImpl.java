package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction transaction) {
        fruitDao.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
