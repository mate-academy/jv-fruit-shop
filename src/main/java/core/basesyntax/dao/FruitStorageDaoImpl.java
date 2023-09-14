package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Fruit add(Fruit fruit) {
        Storage.fruitsStorage.add(fruit);
        return get(fruit.getName());
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruitsStorage.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Fruit remove(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getName());
        Storage.fruitsStorage.remove(fruitFromDB);
        return fruitFromDB;
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.fruitsStorage);
    }
}
