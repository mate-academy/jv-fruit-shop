package core.basesyntax.operationshandlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storagedao.StorageDao;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateValueInStorage(FruitTransaction transaction) {
        validAmount(transaction);
        if (storageDao.isInStorage(transaction.getFruitName())) {
            storageDao.get(transaction.getFruitName()).setValue(transaction.getQuantity());
        } else {
            storageDao.add(new Fruit(transaction.getFruitName()), transaction.getQuantity());
        }
    }

}
