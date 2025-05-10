package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(ShopTransaction shopTransaction) {
        Storage.fruitShopStorage.put(shopTransaction.getFruitName(), shopTransaction.getWeight());
    }
}
