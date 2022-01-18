package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Optional;

public interface FruitDao {
    Optional<Integer> get(Fruit fruit);

    void put(Fruit fruit, int amount);
}
