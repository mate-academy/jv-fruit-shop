package core.basesyntax.dao;

public interface StorageDao<K,V> {
    V get(K key);

    boolean update(K key, V value);
}
