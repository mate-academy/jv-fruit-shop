package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Set<Map.Entry<String, Integer>> getMapEntry();

    Integer getQuantity(String fruit);

    void updateData(String fruit, Integer quantity);

}
