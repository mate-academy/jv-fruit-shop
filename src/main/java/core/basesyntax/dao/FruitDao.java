package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {

    Integer getFruitQuantity(Fruit fruit);

    void addFruitQuantity(Fruit fruit, Integer quantity);

    void setFruitQuantity(Fruit fruit, Integer quantity);

    void subtractFruitQuantity(Fruit fruit, Integer quantity);
}
