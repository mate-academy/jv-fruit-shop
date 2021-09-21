package core.basesyntax.service.impl.operationhandlersimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.interfaces.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int apply(FruitOperation fruitOperationdto) {
        Fruit fruit = new Fruit(fruitOperationdto.getFruit().getName());
        int balance = Storage.storage.get(fruit);
        int quantity = fruitOperationdto.getQuantity();
        if (quantity > balance) {
            throw new RuntimeException("We do not have enough" + fruit.getName());
        }
        Storage.storage.put(fruit, balance - quantity);
        return quantity;
    }
}
