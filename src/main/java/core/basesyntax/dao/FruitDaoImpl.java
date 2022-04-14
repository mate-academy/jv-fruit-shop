package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public void update(Fruit fruit) {
        Storage.fruits.remove(get(fruit.getName()));
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(name -> fruitName.equals(name.getName()))
                .findFirst()
                .orElse(null);
    }
}
