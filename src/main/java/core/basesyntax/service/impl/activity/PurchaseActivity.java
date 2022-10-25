package core.basesyntax.service.impl.activity;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseActivity implements ActivityHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storageDao.getValue(fruitTransaction.getFruit());
        storageDao.putValue(fruitTransaction.getFruit(),
                currentQuantity - fruitTransaction.getQuantity());
    }
}
