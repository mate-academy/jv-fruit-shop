package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;

public interface FruitDao {
    void save(Fruit fruit);

    Optional<Fruit> get(String name);

    List<Fruit> getAll();
}
