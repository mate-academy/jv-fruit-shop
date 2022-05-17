package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        if (storageDao.isPresent(fruit)) {
            storageDao.add(fruit, Storage.fruitStorage.get(fruit) + quantity);
        } else {
            storageDao.add(fruit, quantity);
        }
    }
}
