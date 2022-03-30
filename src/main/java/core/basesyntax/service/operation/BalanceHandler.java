package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;

public class BalanceHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public BalanceHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        fruitStorageDao.add(fruitName, quantity);
    }
}
