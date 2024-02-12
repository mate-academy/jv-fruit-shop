package db;

public interface StorageDao<K,V> {
    void put(K key, V value);

    boolean remove(K key, V value);

    V getValue(K key);
}
