package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationsHandler;

public class PurchaseOperationImpl implements OperationsHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(String name, int quantity) {
        Fruit fruit = fruitStorageDao.get(name);
        if (fruit.getQuantity() - quantity > 0) {
            fruit.setQuantity(fruit.getQuantity() - quantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy that amount");
        }
    }
}
