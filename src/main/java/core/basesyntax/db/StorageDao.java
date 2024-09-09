package core.basesyntax.db;

import java.util.Set;

public interface StorageDao {
    void put(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    Set<String> keySet();
}
