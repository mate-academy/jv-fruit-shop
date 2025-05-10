package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void performOperation(FruitTransaction transaction) {
        int currentQuantity = storageDao.getQuantityByFruitName(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient quantity of "
                    + transaction.getFruit() + " in storage.");
        }

        storageDao.save(transaction.getFruit(), newQuantity);
    }
}
