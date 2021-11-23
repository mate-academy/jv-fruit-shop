package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.OperationException;
import core.basesyntax.model.Fruit;

public class Return implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public Return(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (!Storage.fruitStorage.containsKey(fruitName)) {
            throw new OperationException("Unavailable fruit cannot be returned");
        }
        Fruit fruit = fruitStorageDao.get(fruitName);
        fruitStorageDao.update(fruit, quantity);
    }
}
