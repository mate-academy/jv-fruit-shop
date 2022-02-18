package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void makeOperation(String fruit, Integer amount) {
        fruitDao.subtractQuantity(fruit, amount);
    }
}
