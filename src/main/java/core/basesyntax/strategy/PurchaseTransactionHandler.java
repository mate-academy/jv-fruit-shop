package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {

    @Override
    public void updateFruitQuantity(FruitTransaction transaction, int quantityOfFruitsInStorage) {
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.add(transaction.getFruit(),
                quantityOfFruitsInStorage - transaction.getQuantity());
    }
}
