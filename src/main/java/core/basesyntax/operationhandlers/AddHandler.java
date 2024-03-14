package core.basesyntax.operationhandlers;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class AddHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Balance couldn't be less than zero");
        }
        fruitStorageDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
