package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class SupplyOperation implements FruitOperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        Fruit recievedFruit = storageDao.getFruit(fruit);
        if (recievedFruit == null) {
            storageDao.addFruit(fruit, amount);
        } else {
            int newQuantity = recievedFruit.getQuantity() + amount;
            storageDao.update(fruit, newQuantity);
        }
    }
}
