package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.OperationException;
import core.basesyntax.model.Fruit;

public class Purchase implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public Purchase(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        Fruit fruit = this.fruitStorageDao.get(fruitName);
        if (Storage.fruitStorage.get(fruitName).getQuantity() - quantity < 0) {
            throw new OperationException("You can't purchase more products than are available");
        }
        this.fruitStorageDao.update(fruit, -quantity);
    }
}
