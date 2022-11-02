package core.basesyntax.handlers.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;

public class SaveTransactionHandler implements TransactionHandler {
    private final StorageDao storageDao;

    public SaveTransactionHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToAdd = transaction.getQuantity();
        int newQuantity = storageDao.readQuantity(fruit) != null
                ? storageDao.readQuantity(fruit) + quantityToAdd
                : quantityToAdd;
        storageDao.updateProduct(fruit, newQuantity);
    }
}
