package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruitDB.add(fruit);
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruitDB.stream()
                .filter(item -> item.getFruit().equals(fruit))
                .findFirst()
                .get();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getFruit());
        Storage.fruitDB.remove(fruitFromDb);
        Storage.fruitDB.add(fruit);
    }
}
