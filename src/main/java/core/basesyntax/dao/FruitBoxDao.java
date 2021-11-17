package core.basesyntax.dao;

import core.basesyntax.model.FruitBox;

public interface FruitBoxDao {
    void add(FruitBox fruitBox);

    FruitBox get(String fruitType);
}
