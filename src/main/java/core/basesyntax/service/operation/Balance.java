package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class Balance implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public Balance(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        fruitStorageDao.addNewFruitToStorage(new Fruit(fruitName, quantity));
    }
}
