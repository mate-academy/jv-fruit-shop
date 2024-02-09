package strategy;

public interface StorageHandler<K,V> {
    void put(K key, V value);

    boolean remove(K key, V value);

    V getValue(K key);

    String createReport();
}
