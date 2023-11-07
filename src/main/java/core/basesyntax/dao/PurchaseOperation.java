package core.basesyntax.dao;

import core.basesyntax.db.FruitDB;

public class PurchaseOperation implements FruitOperation {
    @Override
    public void performOperation(FruitDB fruitDB, String name, Integer quantity) {
        fruitDB.remove(name, quantity);
    }
}
