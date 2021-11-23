package core.basesyntax.services.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;

public class AddOperationHandlerImpl implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public AddOperationHandlerImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.storage.get(fruitName) == null) {
            fruitStorageDao.add(fruitName, quantity);
        } else {
            quantity += Storage.storage.get(fruitName);
            fruitStorageDao.add(fruitName, quantity);
        }
    }
}
