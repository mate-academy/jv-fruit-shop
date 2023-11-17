package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public boolean handle(String fruit, int quantity) {
        int addQuantity = Storage.FRUITS.get(fruit) + quantity;
        Storage.FRUITS.put(fruit, addQuantity);
        return true;
    }
}
