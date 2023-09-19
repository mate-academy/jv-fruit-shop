package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.TransactionHandler;

public class SupplyHandler implements TransactionHandler {
    private final StorageDaoImpl storageDao;

    public SupplyHandler() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public boolean handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        ValidationService validationService = new ValidationService();
        validationService.validateIncreasing(fruit);

        return storageDao.increaseFruitsAmount(fruit, quantity);
    }
}
