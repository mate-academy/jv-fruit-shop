package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        int currentQuantity = (storageDao.getFruitsQuantity(fruitTransaction.getFruit()) == null)
                ? 0 : storageDao.getFruitsQuantity(fruitTransaction.getFruit());
        int newQuantity = currentQuantity + fruitTransaction.getQuantity();
        storageDao.putNewValues(fruitTransaction.getFruit(), newQuantity);
    }
}
