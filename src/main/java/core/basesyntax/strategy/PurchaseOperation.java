package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopTransaction;
import exception.OperationException;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(ShopTransaction shopTransaction) {
        String fruit = shopTransaction.getFruitName();
        int weight = Storage.fruitShopStorage.get(fruit);
        int weightToBuy = shopTransaction.getWeight();
        if (weightToBuy > weight) {
            throw new OperationException("Operation impossible, not enough quantity " + fruit);
        }
        Storage.fruitShopStorage.put(fruit, weight - weightToBuy);
    }
}
