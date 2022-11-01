package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruit, Integer quantity);

    void updateQuantity(String fruit, Integer quantity);

    Integer getQuantity(String fruit);

    Map<String, Integer> getStorage();
}
