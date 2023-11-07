package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public interface FruitOperation {
    void performOperation(FruitDB fruitDB, String name, Integer quantity);
}
