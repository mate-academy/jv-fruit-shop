package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getFruitByName(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElseGet(() -> new Fruit(fruitName));
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = getFruitByName(fruit.getName());
        Storage.fruits.remove(fruitFromDb);
        add(fruit);
    }
}
