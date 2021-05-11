package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Optional;
import java.util.Set;

public interface FruitDao {
    void update(Fruit key, Integer value);

    Optional<Integer> get(Fruit key);

    Set<Fruit> getFruits();
}
