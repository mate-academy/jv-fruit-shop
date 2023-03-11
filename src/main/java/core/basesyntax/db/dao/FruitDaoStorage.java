package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoStorage implements FruitDao {

    @Override
    public void create(Fruit fruit, int quantity) {
        Storage.fruitsStorage.put(fruit, quantity);
    }

    @Override
    public Integer read(Fruit fruit) {
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
    public void update(Fruit fruit, int quantity) {
        Storage.fruitsStorage.replace(fruit, quantity);
    }
}
