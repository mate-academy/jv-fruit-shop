package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(Fruit key, Integer value) {
        Storage.getFruits().put(key, value);
    }

    @Override
    public Optional<Integer> get(Fruit key) {
        return Optional.ofNullable(Storage.getFruits().get(key));
    }

    @Override
    public Set<Fruit> getFruits() {
        return Storage.getFruits().keySet();
    }
}
