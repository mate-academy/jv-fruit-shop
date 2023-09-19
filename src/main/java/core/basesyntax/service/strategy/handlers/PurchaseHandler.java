package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    private final StorageDaoImpl storageDao;

    public PurchaseHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService();
        validationService.validateDecreasing(fruit, quantity);

        return storageDao.decreaseFruitsAmount(fruit, quantity);
    }
}
