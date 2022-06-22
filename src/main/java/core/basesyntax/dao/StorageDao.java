package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Integer getFruitsQuantity(String fruit);

    void putNewValues(String fruit, Integer quantity);

    Map<String, Integer> getData();
}
