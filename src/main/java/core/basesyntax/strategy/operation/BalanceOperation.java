package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;

public class BalanceOperation implements OperationHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void operationType(String fruit, int amount) {
        storageDao.addFruit(new Fruit(fruit, amount));
    }
}
