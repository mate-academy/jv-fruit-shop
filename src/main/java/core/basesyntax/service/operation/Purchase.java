package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.OperationException;

public class Purchase implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public Purchase(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (Storage.fruitStorage.get(fruitName) - quantity < 0) {
            throw new OperationException("You can't purchase more products than are available");
        }
        this.fruitStorageDao.update(fruitName, -quantity);
    }
}
