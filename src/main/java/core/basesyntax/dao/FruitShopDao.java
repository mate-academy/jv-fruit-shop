package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;

public interface FruitShopDao {
    void add(Fruit fruit);

    Optional<Fruit> get(String name);

    List<Fruit> getAll();
}
