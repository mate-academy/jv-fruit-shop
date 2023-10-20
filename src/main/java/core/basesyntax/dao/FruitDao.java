package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    Fruit get(String name);

    void add(Fruit fruit);

    void update(Fruit fruit);

    List<Fruit> getAll();
}
