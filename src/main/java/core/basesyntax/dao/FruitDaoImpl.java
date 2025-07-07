package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String nameFruit) {
        return Storage.fruits.stream()
                .filter(f -> (f != null && f.getName().equals(nameFruit)))
                .findFirst()
                .get();
    }

    @Override
    public boolean isPresent(String nameFruit) {
        return Storage.fruits.stream()
                .anyMatch(f -> (f != null && f.getName().equals(nameFruit)));
    }
}
