package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void put(Fruit fruitData, int quantity);

    void addQuantity(Fruit fruit, int quantity);

    void subtract(Fruit fruitData, int quantity);

    int get(Fruit fruitName);
}
