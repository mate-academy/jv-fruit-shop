package core.basesyntax.dao;

import core.basesyntax.fruitmodel.Fruit;
import java.util.Map;

public interface FruitDao {
    void save(Fruit fruit, Integer quantity);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
