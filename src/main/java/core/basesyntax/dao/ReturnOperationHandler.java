package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void performOperation(FruitDB fruitDB, String name, Integer quantity) {
        fruitDB.add(name, quantity);
    }
}
