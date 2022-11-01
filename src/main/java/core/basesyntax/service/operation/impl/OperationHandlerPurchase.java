package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.operation.OperationHandler;

public class OperationHandlerPurchase implements OperationHandler {
    private FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void doOperation(String fruit, Integer quantity) {
        Integer oldQuantity = fruitDao.get(fruit);
        fruitDao.updateQuantity(fruit, oldQuantity - quantity);
    }
}
