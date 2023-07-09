package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(String fruitName, String quantity) {
        Storage.FRUIT_STORAGE.get(fruitName.toLowerCase())
                .subtractQuantity(Integer.parseInt(quantity));
    }
}
