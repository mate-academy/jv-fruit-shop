package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao<K> {
    boolean add(K key);

    boolean update(K oldValue, K newValue);

    Fruit getFruit(String fruitName);

    List<K> getAll();
}
