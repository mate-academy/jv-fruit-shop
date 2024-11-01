package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(ShopTransaction shopTransaction) {
        String fruit = shopTransaction.getFruitName();
        int weight = Storage.fruitShopStorage.get(fruit);
        if (weight > 0) {
            Storage.fruitShopStorage.put(fruit, weight + shopTransaction.getWeight());
        } else {
            Storage.fruitShopStorage.put(fruit, shopTransaction.getWeight());
        }
    }
}
