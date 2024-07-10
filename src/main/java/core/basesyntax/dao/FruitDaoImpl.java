package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit newFruit) {
        Storage.fruits.put(newFruit.getName(), newFruit);
    }

    @Override
    public Optional<Fruit> getFruitIfPresent(String fruitsName) {
        return Optional.ofNullable(Storage.fruits.get(fruitsName));
    }
}
