package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class SupplyHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {

        this.storageDao = storageDao;
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService(storageDao);
        validationService.validateIncreasing(fruit);

        return storageDao.increaseFruitsAmount(fruit, quantity);
    }
}
