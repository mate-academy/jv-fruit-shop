package core.basesyntax.dao;

import java.util.Map;

public interface WarehouseDao {
    void updateQuantity(String fruit, Integer quantity);

    int getQuantity(String fruit);

    String getFruitFromDb(String fruit);

    Map<String, Integer> getLeftovers();
}

