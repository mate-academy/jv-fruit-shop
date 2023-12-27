package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {

    Integer getFruitQuantity(Fruit fruit);

    void updateFruitQuantity(Fruit fruit, Integer quantity);
}
