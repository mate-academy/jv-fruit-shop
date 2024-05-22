package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import java.util.Optional;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(Fruits newFruit) {
        Storage.fruits.removeIf(fruit -> fruit.getName().equals(newFruit.getName()));
        Storage.fruits.add(newFruit);
    }

    @Override
    public Optional<Fruits> getFruitsIfPresent(String fruitsName) {
        for (Fruits fruitsFromDb : Storage.fruits) {
            if (fruitsFromDb.getName().equals(fruitsName)) {
                return Optional.of(fruitsFromDb);
            }
        }
        return Optional.empty();
    }
}
