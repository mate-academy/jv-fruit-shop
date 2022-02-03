package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    void addFruit(Fruit fruit, int quantityToAdd);

    Integer getQuantityByFruit(Fruit fruit);

    boolean subtractQuantityByFruit(Fruit fruit, int quantityToSubtract);

    void addQuantityByFruit(Fruit fruit, int quantityToAdd);
}
