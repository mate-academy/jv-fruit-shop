package core.basesyntax.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class ReturnTransactionHandler implements TransactionHandler {
    private StorageDao storage;

    public ReturnTransactionHandler(StorageDao storageDao) {
        this.storage = storageDao;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (storage.get(fruit) == null) {
            throw new RuntimeException("Trying to return a fruit from another shop!");
        }
        Integer newQuantity = storage.get(fruit) + transaction.getQuantity();
        storage.add(fruit, newQuantity);
        return true;
    }
}
