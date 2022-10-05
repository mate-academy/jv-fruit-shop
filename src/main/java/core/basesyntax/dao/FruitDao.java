package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void update(Fruit fruit, Integer quantity);

    Integer getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
