package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit add(Fruit fruit) {
        Storage.fruits.add(fruit);
        return fruit;
    }

    @Override
    public Optional<Fruit> getByName(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst();
    }
}
