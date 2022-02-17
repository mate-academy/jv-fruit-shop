package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitType) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruitType().equals(fruitType))
                .findFirst().get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromStorage = get(fruit.getFruitType());
        Storage.fruits.remove(fruitFromStorage);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.fruits);
    }
}
