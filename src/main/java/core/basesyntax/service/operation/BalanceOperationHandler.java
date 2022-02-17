package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void changeData(FruitTransaction fruitTransaction) {
        Fruit newFruit = new Fruit();
        newFruit.setFruitType(fruitTransaction.getFruitType());
        newFruit.setAmount(fruitTransaction.getAmount());
        storageDao.add(newFruit);
    }
}
