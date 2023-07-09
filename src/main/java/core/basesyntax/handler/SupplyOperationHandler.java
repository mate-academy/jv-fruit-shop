package core.basesyntax.handler;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements ShopOperationHandler {
    @Override
    public void doOperation(String fruitName, String quantity) {
        Storage.FRUIT_STORAGE.get(fruitName.toLowerCase())
                .addQuantity(Integer.parseInt(quantity));
    }
}
