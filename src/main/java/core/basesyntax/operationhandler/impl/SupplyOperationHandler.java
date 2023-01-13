package core.basesyntax.operationhandler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;

public class SupplyOperationHandler extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (storageDao.containsFruit(fruit)) {
            storageDao.mergeQuantity(fruit, quantity);
        } else {
            storageDao.addFruit(fruit, quantity);
        }

    }
}
