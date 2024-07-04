package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;

public class PurchaseOperation implements FruitOperationHandler {
    private StorageDao storageDao;

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
            throw new RuntimeException(newQuantity + " invalid value of quantity. "
                    + "Quantity can't be less than 0");
        }
        storageDao.update(fruit, newQuantity);
    }
}
