package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;

public class PurchaseOperation implements FruitOperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        int newQuantity = storageDao.getFruit(fruit).getQuantity() - amount;
        if (newQuantity < 0) {
            throw new RuntimeException("Quantity can't be "
                    + "less than 0. Actual quantity value is " + newQuantity);
        } else {
            storageDao.update(fruit, newQuantity);
        }
    }
}
