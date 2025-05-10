package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.exception.NegativeAmountInStorageException;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private static final String NEGATIVE_AMOUNT_MESSAGE = "Operation from your list caused "
                                                + "negative balance. Please check input data";
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storage) {
        this.storageDao = storage;
    }

    @Override
    public void handle(String productType, int amount) {
        int newAmount = storageDao.getAmountByProduct(productType) - amount;
        if (newAmount < 0) {
            throw new NegativeAmountInStorageException(NEGATIVE_AMOUNT_MESSAGE);
        }
        storageDao.putToInventory(productType, newAmount);
    }
}
