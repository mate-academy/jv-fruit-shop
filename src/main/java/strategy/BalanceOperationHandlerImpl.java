package strategy;

import dao.StorageDao;
import model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void changeQuantity(FruitTransaction fruitTransaction) {
        storageDao.updateData(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
