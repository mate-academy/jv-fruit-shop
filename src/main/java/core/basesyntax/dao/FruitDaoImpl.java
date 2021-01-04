package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(int i) {
        return Storage.fruits.get(i);
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruitName().equals(fruit))
                .findFirst()
                .get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getFruitName());
        fruitFromDb.setAmount(fruit.getAmount());
    }
}
