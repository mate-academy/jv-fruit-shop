package core.basesyntax.service.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivityHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public BalanceActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Wrong quantity: " + fruitTransaction.getQuantity());
        }
        fruitDao.updateFruitQuantity(fruit, fruitTransaction.getQuantity());
    }
}
