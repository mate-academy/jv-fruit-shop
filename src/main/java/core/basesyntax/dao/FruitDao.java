package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void add(Fruit fruit, int amount);

    boolean contains(Fruit fruit);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
