package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public SupplyHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.fruitStorage.containsKey(fruitName)) {
            fruitStorageDao.update(fruitName, quantity);
        } else {
            fruitStorageDao.add(fruitName, quantity);
        }
    }
}
