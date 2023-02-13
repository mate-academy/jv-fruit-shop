package core.basesyntax.dao;

import java.util.Map;

public interface WarehouseDao {
    void setQuantity(String fruit, Integer quantity);

    int getQuantity(String fruit);

    boolean isPresent(String fruit);

    Map<String, Integer> getLeftovers();
}

