package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public Map<String, Integer> getOperation(FruitTransaction transaction) {
        storageDao.save(transaction.getFruit(),
                storageDao.getQuantity(transaction.getFruit()) - transaction.getQuantity());
        return storageDao.getAll();
    }
}
