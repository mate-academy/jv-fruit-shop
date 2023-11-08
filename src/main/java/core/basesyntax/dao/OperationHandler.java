package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public interface OperationHandler {
    void performOperation(FruitDB fruitDB, String name, Integer quantity);
}
