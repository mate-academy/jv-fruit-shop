package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(String fruitName, String quantityToOperate) {
        Storage.FRUIT_STORAGE.put(fruitName.toLowerCase(),
                Integer.parseInt(quantityToOperate));
    }
}
