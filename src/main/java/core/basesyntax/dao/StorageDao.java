package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void add(Fruit fruit, Integer value);

    void substractAmount(Fruit fruit, Integer amountToDelete);

    Map<Fruit, Integer> getAll();
}
