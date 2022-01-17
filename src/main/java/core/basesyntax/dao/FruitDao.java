package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Optional;

public interface FruitDao {
    Optional<Fruit> get(String name);

    void put(Fruit fruit);
}
