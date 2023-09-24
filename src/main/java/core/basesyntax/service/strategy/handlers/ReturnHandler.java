package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class ReturnHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public ReturnHandler(StorageDao storageDao) {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService(storageDao);
        validationService.validateIncreasing(fruit);

        return storageDao.increaseFruitsAmount(fruit, quantity);
    }
}
