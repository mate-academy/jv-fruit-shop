package core.basesyntax.stratagy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stratagy.OperationPerformer;

public class PurchaseOperationPerformer implements OperationPerformer {
    @Override
    public void perform(StorageDao storageDao, FruitTransaction transaction) {
        storageDao.reduce(transaction.getFruit(), transaction.getQuantity());
    }
}
