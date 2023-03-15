package core.basesyntax.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.management.openmbean.KeyAlreadyExistsException;

public class DaoServiceHashMap<K, V> implements DaoService<K,V> {
    private Map<K,V> memory;

    public DaoServiceHashMap() {
        this.memory = new HashMap<>();
    }

    @Override
    public void create(K key, V value) {
        if (memory.containsKey(key)) {
            throw new KeyAlreadyExistsException("Storage already contains value for " + key);
        }
        memory.put(key, value);
    }

    @Override
    public void update(K key, V value) {
        memory.put(key, value);
    }

    @Override
    public V getByKey(K key) {
        return memory.get(key);
    }

    @Override
    public Collection<Map.Entry<K,V>> getAll() {
        return memory.entrySet();
    }
}
