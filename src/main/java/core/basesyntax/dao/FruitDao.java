package core.basesyntax.dao;

import java.util.List;
import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    void update(Fruit fruit);

    List<Fruit> getAll();
}
