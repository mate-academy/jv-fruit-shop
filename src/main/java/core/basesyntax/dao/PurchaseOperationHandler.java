package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void performOperation(FruitDB fruitDB, String name, Integer quantity) {
        fruitDB.remove(name, quantity);
    }
}
