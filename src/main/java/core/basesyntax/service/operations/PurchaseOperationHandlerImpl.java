package core.basesyntax.service.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.template.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldQuantity = storageDao.get(fruitTransaction.getFruit());
        Integer newQuantity = oldQuantity - fruitTransaction.getQuantity();
        if (newQuantity <= 0) {
            throw new RuntimeException("Sorry, the store has run out of fruit "
                    + fruitTransaction.getFruit());
        }
        storageDao.put(fruitTransaction.getFruit(), newQuantity);
    }
}
