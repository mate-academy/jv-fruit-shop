package core.fruitshop.service.strategy.impl;

import core.fruitshop.dao.FruitDao;
import core.fruitshop.db.Storage;
import core.fruitshop.model.Fruit;
import core.fruitshop.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitType, String value) {
        Fruit fruit = new Fruit(fruitType);
        fruitDao.addFruit(fruit);
        int prevQuantity = fruitDao.getQuantity(fruit);
        Storage.fruitsStorage.put(fruit, prevQuantity + Integer.parseInt(value));
    }
}
