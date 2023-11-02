package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public boolean handle(String fruit, int quantity) {
        int removeQuantity = Storage.FRUITS.get(fruit) - quantity;
        Storage.FRUITS.put(fruit,removeQuantity);
        return true;
    }
}
