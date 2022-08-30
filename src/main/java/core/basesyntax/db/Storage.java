package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface Storage {

    void add(Fruit fruit, Integer quantity);

    void remove(Fruit fruit, Integer quantity);

    Map<Fruit, Integer> getAllFruits();
}
