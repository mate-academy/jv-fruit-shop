package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
