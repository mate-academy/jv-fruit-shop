package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getFruit(String fruit) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruit))
                .findFirst().get();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }

    @Override
    public void update(Fruit fruit) {
        Storage.fruits.remove(fruit);
        add(fruit);
    }
}
