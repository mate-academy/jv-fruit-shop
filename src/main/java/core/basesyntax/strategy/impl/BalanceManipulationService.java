package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class BalanceManipulationService implements ManipulationService {
    @Override
    public void manipulate(String name, int quantity, FruitStorageDao fruitStorageDao) {
        Fruit fruit = new Fruit(name, quantity);
        fruitStorageDao.add(fruit);
    }
}
