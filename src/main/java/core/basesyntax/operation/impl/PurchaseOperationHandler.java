package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void get(FruitTransaction fruit) {
        FruitTransaction fruitFromDataBase = fruitDao.get(fruit.getFruit());
        int residual = fruitFromDataBase.getQuantity() - fruit.getQuantity();
        fruitFromDataBase.setQuantity(residual);
        fruitDao.add(fruitFromDataBase);
    }
}

