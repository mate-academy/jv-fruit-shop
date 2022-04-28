package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.TransactionStrategy;

public class PurchaseHandler implements TransactionStrategy<Fruit> {

    @Override
    public void getOperation(Fruit fruit) {
        FruitDao fruitDao = new FruitDaoImpl();
        fruit.setQuantity(fruit.getQuantity() * -1);
        fruitDao.update(fruit);
    }
}
