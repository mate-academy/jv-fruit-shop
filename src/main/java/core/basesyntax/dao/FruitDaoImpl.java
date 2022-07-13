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
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitToUpdate = Storage.fruits.stream()
                .filter(item -> item.getFruitName().equals(fruit.getFruitName()))
                .findFirst()
                .get();
        fruitToUpdate.setQuantity(fruit.getQuantity());
    }
}
