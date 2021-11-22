package core.basesyntax.dao;

import java.util.List;

public interface StorageDao<K, V> {

    Integer put(K key, V value);

    V update(K key, V value);

    List<K> getStorageInfo();

    Integer getCurrentQuantity(K fruit);
}
