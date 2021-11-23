package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class PurchaseManipulationService implements ManipulationService {

    @Override
    public void manipulate(String name, int quantity, FruitStorageDao fruitStorageDao) {
        int updateQuantity;
        Fruit fruit = fruitStorageDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            updateQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(updateQuantity);
        } else {
            throw new RuntimeException("Sorry? but we don`t have enough fruit to buy");
        }
    }
}
