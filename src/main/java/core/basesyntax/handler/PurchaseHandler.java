package core.basesyntax.handler;

import core.basesyntax.database.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void operate(String fruitType, int amount) {
        int amountAfterPurchase = Storage.storage.get(fruitType)
                - amount;
        if (amountAfterPurchase < 0) {
            throw new RuntimeException("Can't "
                    + "do purchase, because amount < purchase");
        }
        Storage.storage.put(fruitType, amountAfterPurchase);
    }
}
