package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class RemovingOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public RemovingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruit) {
        if (fruitDao.getValue(fruit.getName()) < fruit.getAmount()) {
            throw new RuntimeException("Invalid operation, not enough fruits to buy");
        }
        fruitDao.add(fruit.getName(), fruitDao.getValue(fruit.getName())
                - fruit.getAmount());
    }
}
