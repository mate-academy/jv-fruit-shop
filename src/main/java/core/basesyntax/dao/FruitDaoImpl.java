package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit newFruit) {
        Storage.fruits.removeIf(fruit -> fruit.getName().equals(newFruit.getName()));
        Storage.fruits.add(newFruit);
    }

    @Override
    public Optional<Fruit> getFruitIfPresent(String fruitName) {
        for (Fruit fruitFromDb : Storage.fruits) {
            if (fruitFromDb.getName().equals(fruitName)) {
                return Optional.of(fruitFromDb);
            }
        }
        return Optional.empty();
    }
}
