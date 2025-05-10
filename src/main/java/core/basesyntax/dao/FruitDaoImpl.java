package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit newFruit) {
        Storage.addOrUpdateFruit(newFruit.getName(), newFruit);
    }

    @Override
    public Optional<Fruit> getFruitIfPresent(String fruitName) {
        return Optional.ofNullable(Storage.getFruit(fruitName));
    }
}
