package core.basesyntax.service.impl.operationhandlersimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.interfaces.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public int apply(FruitRecord fruitOperationdto) {
        Fruit fruit = new Fruit(fruitOperationdto.getFruit().getName());
        int balance = Storage.storage.getOrDefault(fruit, 0) + fruitOperationdto.getQuantity();
        Storage.storage.put(fruit, balance);
        return balance;
    }
}
