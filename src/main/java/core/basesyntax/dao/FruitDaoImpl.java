package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void addToStorage(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getAmountOfFruits(String name) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst().get();
    }
}
