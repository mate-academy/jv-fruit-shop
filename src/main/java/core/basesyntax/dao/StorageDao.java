package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {

    void save(String fruit, Integer quantity);

    Map<String, Integer> getAll();

    Integer getQuantity(String fruit);
}
