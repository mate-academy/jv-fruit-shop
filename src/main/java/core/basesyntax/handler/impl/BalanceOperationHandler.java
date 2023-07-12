package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;

public class BalanceOperationHandler implements ShopOperationHandler {
    @Override
    public void handle(String fruitName, String quantityToOperate) {
        Storage.fruitStorage.put(fruitName.toLowerCase(),
                Integer.parseInt(quantityToOperate));
    }
}
