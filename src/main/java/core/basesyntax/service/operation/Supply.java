package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;

public class Supply implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public Supply(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.fruitStorage.containsKey(fruitName)) {
            fruitStorageDao.update(fruitName, quantity);
        } else {
            fruitStorageDao.addNewFruitToStorage(fruitName, quantity);
        }
    }
}
