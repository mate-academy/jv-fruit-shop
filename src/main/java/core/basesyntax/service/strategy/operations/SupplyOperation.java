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
        Fruit fruit = transaction.getFruit();
        Integer newQuantity = storageDao.get(fruit)
                + transaction.getQuantity();

        storageDao.save(fruit, newQuantity);
    }
}
