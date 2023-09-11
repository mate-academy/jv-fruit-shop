package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void execute(String fruit, int quantity) {
        int storedAmount = fruitDao.getQuantity(fruit);
        if (storedAmount - quantity < 0) {
            throw new RuntimeException("Quantity of " + fruit
                    + " in storage is less than " + quantity);
        }
        fruitDao.add(fruit, storedAmount - quantity);
    }
}
