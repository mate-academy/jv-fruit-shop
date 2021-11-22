package core.basesyntax.dao;

import java.util.List;

public interface StorageDao<K> {

    boolean put(K key);

    List<K> getStorageInfo();
}
