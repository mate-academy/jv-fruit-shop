package core.fruitshop.service.strategy.impl;

import core.fruitshop.dao.FruitDao;
import core.fruitshop.db.Storage;
import core.fruitshop.model.Fruit;
import core.fruitshop.service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitType, String value) {
        Fruit fruit = new Fruit(fruitType);
        int prevQuantity = fruitDao.getQuantity(fruit);
        if (prevQuantity - Integer.parseInt(value) < 0) {
            throw new RuntimeException("Balance cant be negative");
        }
        Storage.fruitsStorage.put(fruit, prevQuantity - Integer.parseInt(value));
    }
}
