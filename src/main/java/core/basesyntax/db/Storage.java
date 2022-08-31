package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface Storage {
    void add(Fruit fruit, Integer quantity);

    void remove(Fruit fruit, Integer quantity);

    Set<Map.Entry<Fruit, Integer>> getAllFruits();
}
