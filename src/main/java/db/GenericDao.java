package db;

import java.util.Map;

public interface GenericDao<K,V> {
    void update(K k, V v);

    V get(K k);

    Map<K, V> getAll();
}
