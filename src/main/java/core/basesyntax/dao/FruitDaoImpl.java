package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.NoSuchElementException;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(item -> item.getFruit().equals(fruitName))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Fruit wasn't found"));
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitToUpdate = get(fruit.getFruit());
        Storage.fruits.remove(fruitToUpdate);
        fruitToUpdate.setQuantity(fruit.getQuantity());
        Storage.fruits.add(fruitToUpdate);
    }
}
