package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        String fruit = shopOperation.getFruit();
        int quantity = Storage.fruitsStorage.get(fruit);
        Storage.fruitsStorage.put(fruit, quantity + shopOperation.getQuantity());
    }
}
