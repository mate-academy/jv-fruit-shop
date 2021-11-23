package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class SupplyManipulationService implements ManipulationService {
    private FruitStorageDao fruitStorageDao;

    public SupplyManipulationService(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void manipulate(String name, int quantity) {
        Fruit fruit = fruitStorageDao.get(name);
        fruit.setQuantity(fruit.getQuantity() + quantity);
    }
}
