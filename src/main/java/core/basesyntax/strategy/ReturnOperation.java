package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(ShopTransaction shopTransaction) {
        int quantity = Storage.fruitShopStorage.get(shopTransaction.getFruitName());
        Storage.fruitShopStorage.put(shopTransaction.getFruitName(), shopTransaction.getWeight()
                + quantity);
    }
}
