package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Set;

public interface FruitDao {
    void add(Fruit key, Integer value);

    Integer get(Fruit key);

    Set<Fruit> getFruits();
}
