package strategy;

import dao.StorageDao;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.updateData(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
