package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);

    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getName());
        Storage.fruits.remove(fruitFromDb);
        add(fruit);
    }
}
