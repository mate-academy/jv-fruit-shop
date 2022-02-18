package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit) {
        if (fruitIsInStorage(fruit.getFruitName())) {
            throw new RuntimeException("Such type of fruit is present in storage");
        }
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruitName().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public boolean fruitIsInStorage(String fruitName) {
        return Storage.fruits.stream()
                .anyMatch(f -> f.getFruitName().equals(fruitName));
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }
}
