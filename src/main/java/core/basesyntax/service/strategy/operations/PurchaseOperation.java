package core.basesyntax.service.strategy.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer newQuantity = storageDao.get(fruit)
                - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit.getFruitName() + " in the storage");
        }

        storageDao.save(fruit, newQuantity);
    }
}
