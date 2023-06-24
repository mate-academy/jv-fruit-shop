package core.basesyntax.dao;

import core.basesyntax.fruit.Fruit;
import java.util.List;

public interface FruitDao {
    void put(String key, Integer value);

    Integer getByName(String key);

    List<Fruit> getAll();
}
