package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    boolean contains(String fruit);

    void addFruit(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
