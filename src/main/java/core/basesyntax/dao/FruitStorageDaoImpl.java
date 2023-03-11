package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public boolean add(Fruit fruit, int quantity) {
        Storage.getFruitStorage().put(fruit, quantity);
        return true;
    }

    @Override
    public boolean contains(Fruit fruit) {
        return Storage.getFruitStorage().containsKey(fruit);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.getFruitStorage().get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.getFruitStorage();
    }
}
