package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationService implements OperationService {
    private StorageDao storageDao;

    public SupplyOperationService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
