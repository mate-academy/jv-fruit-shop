package core.basesyntax.handlers.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class CommonSavingHandler {
    private final StorageDao storageDao;

    public CommonSavingHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantityToAdd = transaction.getQuantity();
        int newQuantity = storageDao.getQuantity(fruit) != null
                ? storageDao.getQuantity(fruit) + quantityToAdd
                : quantityToAdd;
        storageDao.update(fruit, newQuantity);
    }
}
