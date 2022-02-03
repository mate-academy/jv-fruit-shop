package core.basesyntax.dao;

import java.util.Map;
import core.basesyntax.model.Fruit;

public interface StorageDao {
    void addFruit(Fruit fruit, int quantityToAdd);

    Integer getQuantityByFruit(Fruit fruit);

    void subtractQuantityByFruit(Fruit fruit, int quantityToSubtract);

    void addQuantityByFruit(Fruit fruit, int quantityToAdd);

    Map<Fruit, Integer> getAll();
}
