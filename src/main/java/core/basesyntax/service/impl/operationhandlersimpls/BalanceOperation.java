package core.basesyntax.service.impl.operationhandlersimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.interfaces.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public int apply(FruitOperation fruitOperationdto) {
        Fruit fruit = new Fruit(fruitOperationdto.getFruit().getName());
        int balance = fruitOperationdto.getQuantity();
        Storage.storage.put(fruit, balance);
        return balance;
    }
}
