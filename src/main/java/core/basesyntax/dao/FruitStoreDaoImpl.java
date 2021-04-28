package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public class FruitStoreDaoImpl implements FruitStoreDao {
    @Override
    public void addFruit(Fruit fruit, int quantity) {
        Storage.addFruit(fruit, quantity);
    }

    @Override
    public int getFruitQuantity(Fruit fruit) {
        return Optional.ofNullable(Storage.getFruits().get(fruit)).orElse(0);
    }

    @Override
    public Map<Fruit, Integer> getAllFruits() {
        return Storage.getFruits();
    }
}
