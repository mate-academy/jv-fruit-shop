package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction transaction, StorageDao storageDao) {
        storageDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
