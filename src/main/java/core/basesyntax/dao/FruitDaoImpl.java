package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruitsStorage.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruitsStorage.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getName());
        Storage.fruitsStorage.remove(fruitFromDB);
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.fruitsStorage);
    }
}
