package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit,int quantity) {
        int quantityAfterPurchase = Storage.fruits.get(fruit) - quantity;
        Storage.fruits.put(fruit,quantityAfterPurchase);
    }
}
