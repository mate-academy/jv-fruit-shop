package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public boolean isPresent(String fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public List<String> getAllFruits() {
        return new ArrayList<>(Storage.fruitStorage.keySet());
    }
}
