package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruit, Integer quantity);

    int getQuantity(String fruit);

    boolean contains(String fruit);

    Map<String, Integer> getAll();
}
