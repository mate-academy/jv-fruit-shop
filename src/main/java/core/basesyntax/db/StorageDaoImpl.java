package core.basesyntax.db;

import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    public StorageDaoImpl() {
    }

    @Override
    public void put(String fruit, Integer quantity) {
        Storage.fruits.put(fruit,quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Set<String> keySet() {
        return Storage.fruits.keySet();
    }
}
