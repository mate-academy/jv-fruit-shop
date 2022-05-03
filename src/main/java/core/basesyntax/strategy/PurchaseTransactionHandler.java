package core.basesyntax.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    private StorageDao storage;

    public PurchaseTransactionHandler(StorageDao storageDao) {
        this.storage = storageDao;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (storage.get(fruit) == null) {
            throw new RuntimeException("Trying to purchase non-existing fruit!");
        }
        if (storage.get(fruit) != null
                    && storage.get(fruit) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in a shop!");
        }
        Integer newQuantity = storage.get(fruit) - transaction.getQuantity();
        storage.add(fruit, newQuantity);
        return true;
    }
}
