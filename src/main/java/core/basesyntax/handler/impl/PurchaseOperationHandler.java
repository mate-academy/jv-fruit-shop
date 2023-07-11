package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;

public class PurchaseOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(String fruitName, String quantityToOperate) {
        Integer oldQuantityValue = Storage.FRUIT_STORAGE.get(fruitName.toLowerCase());
        if (oldQuantityValue == null || oldQuantityValue < Integer.parseInt(quantityToOperate)) {
            throw new IllegalArgumentException("Available quantity of " + fruitName
                    + " is less than required for purchase operation");
        }
        Storage.FRUIT_STORAGE.put(fruitName.toLowerCase(),
                oldQuantityValue - Integer.parseInt(quantityToOperate));
    }
}

