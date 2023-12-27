package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Integer getFruitQuantity(Fruit fruit) {
        return Storage.getFruits().getOrDefault(fruit, 0);
    }

    @Override
    public void updateFruitQuantity(Fruit fruit, Integer quantity) {
        Storage.getFruits().merge(fruit, quantity, Integer::sum);
    }
}
