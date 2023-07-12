package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;

public class PurchaseOperationHandler implements ShopOperationHandler {
    @Override
    public void handle(String fruitName, String quantityToOperate) {
        Integer oldQuantityValue = Storage.fruitStorage.get(fruitName.toLowerCase());
        if (oldQuantityValue == null || oldQuantityValue < Integer.parseInt(quantityToOperate)) {
            throw new IllegalArgumentException("Available quantity of " + fruitName
                    + " is less than required for purchase operation");
        }
        Storage.fruitStorage.put(fruitName.toLowerCase(),
                oldQuantityValue - Integer.parseInt(quantityToOperate));
    }
}
