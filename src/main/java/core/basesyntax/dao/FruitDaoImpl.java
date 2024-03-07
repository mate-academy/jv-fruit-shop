package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getFruitName());
        Storage.fruits.remove(fruitFromDB);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.fruits);
    }
}
