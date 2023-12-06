package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public class StorageImpl implements Storage {
    private final Map<String, Integer> storageMap;

    public StorageImpl() {
        this.storageMap = new HashMap<>();
    }

    @Override
    public void put(String key, Integer value) {
        storageMap.put(key, value);
    }

    @Override
    public void merge(String key, Integer value, BinaryOperator<Integer> mergeFunction) {
        storageMap.merge(key, value, mergeFunction);
    }

    @Override
    public Set<Map.Entry<String,Integer>> entrySet() {
        return storageMap.entrySet();
    }
}
