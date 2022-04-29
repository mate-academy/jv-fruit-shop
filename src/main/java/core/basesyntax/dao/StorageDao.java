package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.HashMap;

public interface StorageDao {
    void add(Fruit fruit, Integer quantity);

    void remove(Fruit fruit, Integer quantity);

    int getFruitQuantity(Fruit fruit);

    HashMap<Fruit, Integer> getStorage();
}
