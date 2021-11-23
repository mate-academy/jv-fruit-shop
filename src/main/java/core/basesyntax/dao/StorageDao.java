package core.basesyntax.dao;

import java.util.List;

public interface StorageDao<K> {
    boolean add(K key);

    boolean update(K oldValue, K newValue);

    K getByName(String fruitName);

    List<K> getAll();
}
