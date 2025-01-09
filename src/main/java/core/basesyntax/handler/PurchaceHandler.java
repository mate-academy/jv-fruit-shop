package core.basesyntax.handler;

import core.basesyntax.database.Storage;

public class PurchaceHandler implements OperationHandler {

    @Override
    public void operate(String fruitType, int amount) {
        int amountAfterPurchace = Storage.storage.get(fruitType)
                - amount;
        if (amountAfterPurchace < 0) {
            throw new RuntimeException("Can't "
                    + "do purchase, because amount < purchace");
        }
        Storage.storage.put(fruitType, amountAfterPurchace);
    }
}
