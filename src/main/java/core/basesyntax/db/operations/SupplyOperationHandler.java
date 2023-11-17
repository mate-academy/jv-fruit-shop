package core.basesyntax.db.operations;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.impl.StorageDaoImpl;
import core.basesyntax.model.ItemTransaction;

public class SupplyOperationHandler implements DataOperation {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void handle(ItemTransaction transaction) {
        storageDao.addItem(transaction.getName(), transaction.getQuantity());
    }
}
