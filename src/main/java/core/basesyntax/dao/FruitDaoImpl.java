package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Integer get(Fruit fruit) {
        return Storage.storage.getOrDefault(fruit, 0);
    }

    @Override
    public Integer update(Fruit fruit, Integer amountToAdd) {
        if (amountToAdd < 0 && Math.abs(amountToAdd) > Storage.storage.get(fruit)) {
            throw new RuntimeException("Storage don't have enough "
                    + fruit.getName() + " for sale");
        }
        Storage.storage.put(fruit, get(fruit) + amountToAdd);
        return Storage.storage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.storage;
    }
}
