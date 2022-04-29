package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationService implements OperationService {
    private StorageDao storageDao;

    public BalanceOperationService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
