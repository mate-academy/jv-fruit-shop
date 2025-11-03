package core.basesyntax.service.strategy.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction was null.");
        }
        Fruit fruit = transaction.getFruit();
        int availableQuantity = storageDao.getAll().getOrDefault(fruit, 0);
        Integer newQuantity = availableQuantity + transaction.getQuantity();
        storageDao.save(fruit, newQuantity);
    }
}
