package core.basesyntax.operationhandlers;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReplaceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        String fruit = fruitTransaction.getFruit();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("It is impossible to get a negative quantity of goods");
        }
        fruitStorageDao
                .add(fruit, fruitStorageDao.get(fruit) + fruitTransaction.getQuantity());
    }
}
