package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class ReturnManipulationService implements ManipulationService {

    @Override
    public void manipulate(String name, int quantity, FruitStorageDao fruitStorageDao) {
        Fruit fruit = fruitStorageDao.get(name);
        int updateQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(updateQuantity);
    }
}
