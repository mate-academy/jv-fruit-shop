package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    Integer get(Fruit fruit);

    Integer update(Fruit fruit, Integer amountToAdd);

    Map<Fruit, Integer> getAll();
}
