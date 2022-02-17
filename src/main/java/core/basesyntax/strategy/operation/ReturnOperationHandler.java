package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void changeData(FruitTransaction fruitTransaction) {
        Fruit newFruit = new Fruit();
        Fruit fruitFromStorage = storageDao.get(fruitTransaction.getFruitType());
        newFruit.setFruitType(fruitTransaction.getFruitType());
        newFruit.setAmount(fruitFromStorage.getAmount() + fruitTransaction.getAmount());
        storageDao.update(newFruit);
    }
}
