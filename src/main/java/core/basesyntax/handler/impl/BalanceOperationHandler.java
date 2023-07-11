package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;

public class BalanceOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(String fruitName, String quantityToOperate) {
        Storage.FRUIT_STORAGE.put(fruitName.toLowerCase(),
                Integer.parseInt(quantityToOperate));
    }
}
