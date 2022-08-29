package core.basesyntax.dao;

import core.basesyntax.model.FruitData;

public interface FruitDao {

    void add(FruitData fruitData);

    void remove(FruitData fruitData);

    FruitData get(String fruitName);
}
