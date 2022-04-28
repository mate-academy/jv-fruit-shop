package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.TransactionStrategy;

public class BalanceHandler implements TransactionStrategy<Fruit> {
    @Override
    public void getOperation(Fruit fruit) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        fruitDao.saveToStorage(fruit);
    }
}
