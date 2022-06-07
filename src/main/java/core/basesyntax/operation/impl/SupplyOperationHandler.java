package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void get(FruitTransaction fruit) {
        FruitTransaction fruitFromDataBase = fruitDao.get(fruit.getFruit());
        if (fruitFromDataBase == null) {
            fruitDao.add(fruit);
        } else {
            int amount = fruitFromDataBase.getQuantity() + fruit.getQuantity();
            fruitFromDataBase.setQuantity(amount);
            fruitDao.add(fruitFromDataBase);
        }
    }
}
