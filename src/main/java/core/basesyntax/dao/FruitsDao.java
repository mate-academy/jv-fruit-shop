package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitsDao {
    Fruit add(Fruit fruit);

    Fruit get(String name);

    List<Fruit> getAll();
}
