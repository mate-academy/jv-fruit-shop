package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit add(Fruit fruit) {
        Storage.storage.add(fruit);
        return fruit;
    }

    @Override
    public Optional<Fruit> get(String fruitName) {
        for (Fruit fruit : Storage.storage) {
            if (fruit.getFruitName().equals(fruitName)) {
                return Optional.of(fruit);
            }
        }
        return Optional.empty();
    }

    @Override
    public void updateFruitCount(int newCount, String fruitName) {
        get(fruitName).ifPresent(f -> f.setFruitCount(newCount));
    }

    @Override
    public int getFruitsCount(String fruitName) {
        return get(fruitName)
                .orElseThrow(() -> new RuntimeException("Can`t find fruit with name: " + fruitName))
                .getFruitCount();
    }
}
