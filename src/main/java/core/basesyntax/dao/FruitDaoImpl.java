package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.getFruits().add(fruit);
    }

    @Override
    public Optional<Fruit> getByName(String name) {
        for (Fruit fruit : Storage.getFruits()) {
            if (fruit.getName().equals(name)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }
}
