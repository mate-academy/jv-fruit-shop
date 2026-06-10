package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void set(String fruit, Integer quantity) {
        Storage.setFruitQuantity(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.getFruitQuantity(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getAllFruits();
    }
}
