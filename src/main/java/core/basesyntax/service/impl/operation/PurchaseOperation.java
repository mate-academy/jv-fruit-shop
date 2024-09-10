package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public PurchaseOperation(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean doOperation(Fruit fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("Fruit can't be null");
        }
        if (quantity < MIN_FRUIT_QUANTITY) {
            throw new RuntimeException("Quantity " + quantity + " can't be negative");
        }
        if (fruitStorageDao.getBalance(fruit) < quantity) {
            throw new RuntimeException("Not enough fruits " + fruit + " on balance");
        }
        return fruitStorageDao.subtract(fruit, quantity);
    }
}
