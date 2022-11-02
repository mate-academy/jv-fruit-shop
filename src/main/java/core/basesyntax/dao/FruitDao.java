package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Integer getQuantity(Fruit fruit);

    Integer add(String fruitName, Integer quantity);

    Set<Map.Entry<Fruit, Integer>> getEntrySet();
}
