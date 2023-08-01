package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handler(String fruit, int quantity) {
        if (Storage.storage.get(fruit) == null) {
            throw new RuntimeException("This fruit is not available in the warehouse");
        }
        int quantityBeforePurchase = Storage.storage.get(fruit);
        int quantityAfterPurchase = quantityBeforePurchase - quantity;
        if (quantityAfterPurchase < 0) {
            throw new RuntimeException("There is not enough fruit in the warehouse");
        }
        Storage.storage.put(fruit, quantityAfterPurchase);
    }
}
