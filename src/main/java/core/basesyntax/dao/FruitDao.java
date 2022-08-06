package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    boolean contains(String fruit);

    void addFruit(String fruit, int quantity);

    int getQuantity(String fruit);

    void updateQuantity(String fruit, int quantity);

    Map<String, Integer> getAll();
}
