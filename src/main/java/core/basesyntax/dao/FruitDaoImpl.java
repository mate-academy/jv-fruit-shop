package core.basesyntax.dao;

import core.basesyntax.db.StorageFruits;
import core.basesyntax.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao{
    @Override
    public void add(Fruit fruit) {
        StorageFruits.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return StorageFruits.fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .findFirst().get();
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(StorageFruits.fruits);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getFruitName());
        StorageFruits.fruits.remove(fruitFromDb);
        StorageFruits.fruits.add(fruit);
    }
}
