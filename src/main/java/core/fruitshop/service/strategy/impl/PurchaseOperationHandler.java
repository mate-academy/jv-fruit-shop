package core.fruitshop.service.strategy.impl;

import core.fruitshop.dao.FruitDao;
import core.fruitshop.dao.FruitDaoImpl;
import core.fruitshop.model.Fruit;
import core.fruitshop.service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void doOperation(String fruitType, String quantity) {
        Fruit fruit = new Fruit(fruitType);
        fruitDao.subtractQuantity(fruit, Integer.parseInt(quantity));
    }
}
