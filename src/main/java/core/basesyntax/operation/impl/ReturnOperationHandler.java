package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void get(FruitTransaction fruit) {
        FruitTransaction fruitFromDataBase = fruitDao.get(fruit.getFruit());
        int amount = fruitFromDataBase.getQuantity() + fruit.getQuantity();
        fruitFromDataBase.setQuantity(amount);
        fruitDao.add(fruitFromDataBase);
    }
}
