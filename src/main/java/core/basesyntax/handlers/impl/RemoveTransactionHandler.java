package core.basesyntax.handlers.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;

public class RemoveTransactionHandler implements TransactionHandler {
    private static final String NOT_ENOUGH_FRUITS = "Not enough fruits in the storage";
    private static final String NO_SUCH_FRUIT = "No such fruit in the storage";
    private final StorageDao storageDao;

    public RemoveTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToRemove = transaction.getQuantity();
        if (storageDao.readQuantity(fruit) != null) {
            if (storageDao.readQuantity(fruit) >= quantityToRemove) {
                storageDao.updateProduct(fruit, storageDao.readQuantity(fruit) - quantityToRemove);
            } else {
                throw new RuntimeException(NOT_ENOUGH_FRUITS);
            }
        } else {
            throw new RuntimeException(NO_SUCH_FRUIT);
        }
    }
}
