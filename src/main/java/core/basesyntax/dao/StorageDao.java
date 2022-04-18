package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {

    void decreaseFruitQuantity(Fruit fruit, Integer quantity);

    void increaseFruitQuantity(Fruit fruit, Integer quantity);

    Map<Fruit, Integer> getAll();

}

