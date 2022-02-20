package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public interface FruitDao {
    void add(Fruit fruit, Integer quantity);

    Optional<Integer> get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
