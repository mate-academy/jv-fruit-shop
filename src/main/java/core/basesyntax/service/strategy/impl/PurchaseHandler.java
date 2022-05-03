package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler<Fruit> {
    private FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(Fruit fruit) {
        fruit.setQuantity(fruit.getQuantity() * -1);
        fruitDao.save(fruit);
    }
}
