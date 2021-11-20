package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface StorageDao<K, V> {
    Integer put(K key, V value);
    V update(K key, V value);
    List<Map.Entry<K, V>> get();
    Integer getCurrentQuantity(String fruit);
}
