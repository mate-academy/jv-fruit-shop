package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public boolean add(Fruit fruit) {
        Storage.fruitStorage.add(fruit);
        return true;
    }

    @Override
    public Fruit get(String fruitName) {
        for (Fruit fruit : Storage.fruitStorage) {
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruitStorage;
    }
}
