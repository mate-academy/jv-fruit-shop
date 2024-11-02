package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.FruitStorageDao;

public class PurchaseOperation implements OperationHandler {
    private final FruitStorageDao storageDao;

    public PurchaseOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        if (storageDao.getQuantity(fruitName) < quantity) {
            throw new RuntimeException("Not enough " + fruitName + " in the storage");
        }
        Integer previousQuantity = storageDao.getQuantity(fruitName);
        Integer newQuantity = previousQuantity - quantity;
        storageDao.setQuantity(fruitName, newQuantity);
    }
}
