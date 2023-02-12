package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    int add(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
