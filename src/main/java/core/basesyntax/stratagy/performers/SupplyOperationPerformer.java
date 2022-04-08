package core.basesyntax.stratagy.performers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageDao;

public class SupplyOperationPerformer implements core.basesyntax.stratagy.OperationPerformer {
    @Override
    public void perform(StorageDao storageDao, FruitTransaction transaction) {
        storageDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
