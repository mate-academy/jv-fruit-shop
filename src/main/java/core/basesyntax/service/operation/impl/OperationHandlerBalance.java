package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.operation.OperationHandler;

public class OperationHandlerBalance implements OperationHandler {
    private FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void operate(String fruit, Integer quantity) {
        fruitDao.addFruit(fruit, quantity);
    }
}
