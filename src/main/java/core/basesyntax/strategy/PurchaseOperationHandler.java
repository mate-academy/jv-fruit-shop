package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit, Integer quantity) {
        int amountOfFruitAfterSell = Storage.getStorage().get(fruit) - quantity;
        Storage.getStorage().put(fruit, amountOfFruitAfterSell);
    }
}
