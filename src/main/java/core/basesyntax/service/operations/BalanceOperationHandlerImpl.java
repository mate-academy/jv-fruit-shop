package core.basesyntax.service.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.template.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }


}
