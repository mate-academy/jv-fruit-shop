package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void updateData(String fruit, Integer quantity);

    Integer getFruitBalance(String fruit);

    Map<String, Integer> getStorage();
}
