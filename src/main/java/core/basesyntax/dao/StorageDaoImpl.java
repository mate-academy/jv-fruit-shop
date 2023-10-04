package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private final Map<String, Integer> fruitStorageMap;

    public StorageDaoImpl() {
        this.fruitStorageMap = new HashMap<>();
    }

    @Override
    public void add(String fruitName, Integer amount) {
        fruitStorageMap.put(fruitName, amount);
    }

    @Override
    public Integer getCurrentAmount(String fruitName) {
        return fruitStorageMap.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return fruitStorageMap;
    }
}
