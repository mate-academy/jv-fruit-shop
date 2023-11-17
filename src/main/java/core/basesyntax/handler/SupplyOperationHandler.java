package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public boolean handle(String fruit, int quantity) {
        int currentQuantity = Storage.FRUITS.get(fruit);
        Storage.FRUITS.put(fruit, currentQuantity + quantity);
        return true;
    }
}
