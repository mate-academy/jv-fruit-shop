package core.basesyntax.service.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public SupplyActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitDao.getFruit(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Wrong quantity: " + fruitTransaction.getQuantity());
        }
        fruitDao.updateQuantity(fruit, fruitDao.getQuantityFromFruit(fruit)
                + fruitTransaction.getQuantity());
    }
}
