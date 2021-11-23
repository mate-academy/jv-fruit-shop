package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class Supply implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public Supply(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        Fruit fruit = fruitStorageDao.get(fruitName);
        if (Storage.fruitStorage.containsKey(fruitName)) {
            fruitStorageDao.update(fruit, quantity);
        } else {
            fruitStorageDao.addNewFruitToStorage(new Fruit(fruitName, quantity));
        }
    }
}
