package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    void add(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String,Integer> getAll();
}
