package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.math.BigDecimal;
import java.util.List;

public interface FruitDao {
    Fruit get(Fruit fruit);

    void add(Fruit fruit);

    boolean update(Fruit fruit, BigDecimal value);

    List<Fruit> getAll();
}
