package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;

public class PurchaseManipulationService implements ManipulationService {
    private FruitStorageDao fruitStorageDao;

    public PurchaseManipulationService(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void manipulate(String name, int quantity) {
        int updateQuantity;
        Fruit fruit = fruitStorageDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            updateQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(updateQuantity);
        } else {
            throw new RuntimeException("Sorry, but we don`t have enough fruit to buy");
        }
    }
}
