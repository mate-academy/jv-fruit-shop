package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;

public class FruitDaoStorage implements FruitDao {
    @Override
    public void create(Fruits fruits) {
        Storage.fruitsStorage.add(fruits);
    }

    @Override
    public Fruits read(Fruits fruits) {
        return null;
    }

    @Override
    public void update(Fruits fruits) {

    }

    @Override
    public void delete(Fruits fruits) {

    }
}
