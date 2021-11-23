package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao<Fruit> {
    @Override
    public boolean add(Fruit fruit) {
        return Storage.fruitStorage.add(fruit);
    }

    @Override
    public boolean update(Fruit oldValue, Fruit newValue) {
        if (Storage.fruitStorage.remove(oldValue)) {
            Storage.fruitStorage.add(newValue);
            return true;
        }
        return false;
    }

    @Override
    public Fruit getByName(String fruitName) {
        for (Fruit fruit : Storage.fruitStorage) {
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public List<Fruit> getAll() {
        return List.copyOf(Storage.fruitStorage);
    }
}
