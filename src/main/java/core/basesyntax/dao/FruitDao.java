package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void add(Fruit fruit, Integer amount);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
