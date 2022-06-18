
package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ShopDao {
    void add(Fruit fruit, int amount);

    Map<Fruit, Integer> getFruits();

}
