package dao;

import db.Storage;
import java.util.Map;
import java.util.Optional;
import model.Fruit;

public class DaoOptionImpl implements DaoOption {

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
    public Optional<Integer> getFruit(Fruit fruit) {
        return Optional.ofNullable(Storage.fruits.get(fruit));
    }
}
