package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStorageDao {
    void update(Fruit fruit, int quantity);

    int getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
