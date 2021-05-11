package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public interface FruitDao {
    void save(Fruit fruit, int quantity);

    Optional<Integer> getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
