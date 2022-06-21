
package core.basesyntax.dao;

import java.util.Map;

public interface ShopDao {
    void add(String fruit, int amount);

    Map<String, Integer> getFruits();
}
