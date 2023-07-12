package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;

public class ReturnOperationHandler implements ShopOperationHandler {
    @Override
    public void handle(String fruitName, String quantityToOperate) {
        Integer oldQuantityValue = Storage.fruitStorage.get(fruitName.toLowerCase());
        oldQuantityValue = oldQuantityValue == null ? 0 : oldQuantityValue;
        Storage.fruitStorage.put(fruitName.toLowerCase(),
                Integer.parseInt(quantityToOperate) + oldQuantityValue);
    }
}
