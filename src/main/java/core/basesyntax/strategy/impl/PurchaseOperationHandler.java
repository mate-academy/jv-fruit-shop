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
        Integer oldQuantity = fruitDao.getFruitQuantity(fruit);
        if (oldQuantity < amount) {
            throw new RuntimeException(
                    "The quantity in Storage is less than amount for fruit" + fruit);
        }
        fruitDao.updateQuantity(fruit, oldQuantity - amount);
    }
}
