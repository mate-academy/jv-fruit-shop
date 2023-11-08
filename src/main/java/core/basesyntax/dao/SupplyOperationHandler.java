package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void performOperation(FruitDB fruitDB, String name, Integer quantity) {
        fruitDB.add(name, quantity);
    }
}
