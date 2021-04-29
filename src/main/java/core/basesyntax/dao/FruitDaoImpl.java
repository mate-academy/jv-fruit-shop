package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit key, Integer value) {
        Storage.getFruits().put(key, value);
    }

    @Override
    public Integer get(Fruit key) {
        return Storage.getFruits().get(key);
    }

    @Override
    public Set<Fruit> getFruits() {
        return Storage.getFruits().keySet();
    }
}
