package core.basesyntax.stratagy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationPerformer implements core.basesyntax.stratagy.OperationPerformer {
    @Override
    public void perform(StorageDao storageDao, FruitTransaction transaction) {
        storageDao.reduce(transaction.getFruit(), transaction.getQuantity());
    }
}
