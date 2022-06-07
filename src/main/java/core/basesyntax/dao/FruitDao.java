package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruit);
}
