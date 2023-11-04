package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private static final String RUNTIME_EXCEPTION_MESSAGE = "Quantity can't be negative";
    private final StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE);
        }
        storageDao.putToStorage(fruit, quantity);
    }
}
