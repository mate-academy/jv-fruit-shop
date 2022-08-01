package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(String fruitName, Integer fruitQuantity) {
        storage.getFruitStorage().put(fruitName, fruitQuantity);
    }

    @Override
    public Integer get(String fruitName) {
        return storage.getFruitStorage().get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getFruitStorage();
    }
}
