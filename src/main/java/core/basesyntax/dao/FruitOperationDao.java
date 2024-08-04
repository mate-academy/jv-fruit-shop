package core.basesyntax.dao;

import core.basesyntax.model.FruitOperation;

public interface FruitOperationDao {
    void add(FruitOperation fruitOperation);

    FruitOperation get(String fruit);

    void update(FruitOperation fruitOperation);
}
