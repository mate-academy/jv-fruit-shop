package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class BalanceManipulationService implements ManipulationService {
    private FruitStorageDao fruitStorageDao;

    public BalanceManipulationService(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void manipulate(String name, int quantity) {
        Fruit fruit = new Fruit(name, quantity);
        fruitStorageDao.add(fruit);
    }
}
