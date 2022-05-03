package core.basesyntax.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.models.Fruit;
import core.basesyntax.models.Transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    private StorageDao storage;

    public SupplyTransactionHandler(StorageDao storageDao) {
        this.storage = storageDao;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer newQuantity = storage.get(fruit) + transaction.getQuantity();
        storage.add(fruit, newQuantity);
        return true;
    }
}
