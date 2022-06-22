package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        int currentQuantity = storageDao.getFruitsQuantity(fruitTransaction.getFruit());
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There are no enough fruits for this transaction");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Negative transaction is impossible");
        }
        int newQuantity = currentQuantity - fruitTransaction.getQuantity();
        storageDao.putNewValues(fruitTransaction.getFruit(), newQuantity);
    }
}
