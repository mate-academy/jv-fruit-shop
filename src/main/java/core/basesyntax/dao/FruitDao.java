package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    Fruit get(String fruitName);

    void add(String fruitName);

    void update(String fruitName,int quantity);
}
