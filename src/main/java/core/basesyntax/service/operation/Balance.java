package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;

public class Balance implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public Balance(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        fruitStorageDao.addNewFruitToStorage(fruitName, quantity);
    }
}
