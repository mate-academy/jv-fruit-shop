package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    List<Fruit> getAll();
}
