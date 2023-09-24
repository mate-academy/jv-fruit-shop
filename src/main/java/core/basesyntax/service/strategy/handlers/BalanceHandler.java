package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {

        this.storageDao = storageDao;
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService(storageDao);
        validationService.validateAddingNew(fruit);

        return storageDao.addNewFruit(fruit, quantity);
    }
}
