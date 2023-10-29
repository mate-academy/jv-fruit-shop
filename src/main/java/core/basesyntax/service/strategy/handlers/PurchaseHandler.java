package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService(storageDao);
        validationService.validateDecreasing(fruit, quantity);

        return storageDao.decreaseFruitsAmount(fruit, quantity);
    }
}
