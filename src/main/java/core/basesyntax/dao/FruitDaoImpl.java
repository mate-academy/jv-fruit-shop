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
        Fruit fruit;
        boolean isFruitInStore = Storage.fruits.stream()
                .anyMatch(f -> f.getFruitName().equals(fruitName));
        if (isFruitInStore) {
            fruit = Storage.fruits.stream()
                    .filter(f -> f.getFruitName().equals(fruitName))
                    .findFirst()
                    .get();
        } else {
            fruit = new Fruit(fruitName, 0);
            add(fruit);
        }
        return fruit;
    }
}
