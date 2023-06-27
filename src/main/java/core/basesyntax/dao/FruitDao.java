package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void setQuantity(String fruit, Integer quantity);

    void updateQuantity(String fruit, Integer amount);

    Map<String, Integer> getFruits();
}
