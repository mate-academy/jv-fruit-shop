package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    int getQuantityByName(String fruit);

    void saveQuantity(String fruit, int quantity);

    Map<String, Integer> getAll();
}
