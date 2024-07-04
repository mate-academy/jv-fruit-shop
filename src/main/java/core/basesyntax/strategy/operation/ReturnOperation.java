package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;

public class ReturnOperation implements FruitOperationHandler {
    private StorageDao storageDao;

    public ReturnOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        int newQuantity = storageDao.getFruit(fruit).getQuantity() + amount;
        storageDao.update(fruit, newQuantity);
    }
}
