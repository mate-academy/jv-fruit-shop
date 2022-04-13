package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void execute(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        if (storageDao.getValue(fruit) >= quantity) {
            storageDao.update(fruit, -quantity);
        } else {
            throw new RuntimeException("Not enough " + fruit.getName() + " in stock");
        }
    }
}
