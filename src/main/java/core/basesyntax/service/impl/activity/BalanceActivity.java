package core.basesyntax.service.impl.activity;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivity implements ActivityHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        storageDao.putValue(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
