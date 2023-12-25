package core.basesyntax.service.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public PurchaseActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitDao.getFruit(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Wrong quantity: " + fruitTransaction.getQuantity());
        }
        if (fruitDao.getQuantityFromFruit(fruit) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("It is not enought quantity fruits in store!");
        }
        fruitDao.updateQuantity(fruit, fruitDao.getQuantityFromFruit(fruit)
                - fruitTransaction.getQuantity());
    }
}
