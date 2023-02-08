package core.basesyntax.dao;

import java.util.Map;

public interface WarehouseDao {
    void addLeftovers(String fruit, Integer quantity);

    Map<String, Integer> getWarehouse();
}
