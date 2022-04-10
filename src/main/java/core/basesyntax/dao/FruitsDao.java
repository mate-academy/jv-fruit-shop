package core.basesyntax.dao;

import core.basesyntax.database.FruitDto;

public interface FruitsDao {
    FruitDto get(String fruit);

    void put(FruitDto fruitDto);
}
