package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void update(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    Map<String, Integer> getStorage();
}
