package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {

    Fruit getFruit(Fruit fruit);

    Integer getQuantityFromFruit(Fruit fruit);

    void updateQuantity(Fruit fruit, Integer quantity);
}
