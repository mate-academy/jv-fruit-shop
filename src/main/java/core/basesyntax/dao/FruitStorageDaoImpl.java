package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Optional<Fruit> getFruit(String fruitName) {
        return Storage.fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst();
    }

    @Override
    public void update(Fruit fruit) {
        Optional<Fruit> fruitFromDb = getFruit(fruit.getName());
        fruitFromDb.ifPresent(Storage.fruits::remove);
        add(fruit);
    }

    @Override
    public List<Fruit> getFruitList() {
        return Storage.fruits;
    }
}
