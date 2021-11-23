package dao;

import db.Storage;
import java.util.Map;
import java.util.Optional;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, int quality) {
        Storage.fruits.put(fruit, quality);
    }

    @Override
    public void addAll(Map<Fruit, Integer> fruits) {
        for (Map.Entry<Fruit, Integer> set : fruits.entrySet()) {
            add(set.getKey(), set.getValue());
        }
    }

    @Override
    public Optional<Integer> getQuantity(Fruit fruit) {
        return Optional.ofNullable(Storage.fruits.get(fruit));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
