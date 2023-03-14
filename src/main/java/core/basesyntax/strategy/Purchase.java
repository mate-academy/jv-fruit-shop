package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exeption.MyShopExceptions;

public class Purchase implements OperationHandler {
    @Override
    public void operationWithFruits(String fruit, Integer quantity) {
        if (Storage.get(fruit) < quantity) {
            throw new MyShopExceptions("Not enough " + fruit + "we have only" + quantity);
        }
        Storage.put(fruit, Storage.get(fruit) - quantity);
    }
}
