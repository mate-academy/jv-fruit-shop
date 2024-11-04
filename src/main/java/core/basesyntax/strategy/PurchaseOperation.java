package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;
import exception.OperationException;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        String fruit = shopOperation.getFruit();
        if (!Storage.fruitsStorage.containsKey(fruit)) {
            throw new OperationException("Operation is not correct: " + shopOperation);
        }
        int quantity = Storage.fruitsStorage.get(fruit);
        int quantityToBuy = shopOperation.getQuantity();
        if (quantity < quantityToBuy) {
            throw new OperationException("Operation is impossible, not enough quantity of: "
                    + fruit);
        }
        Storage.fruitsStorage.put(fruit, quantity - quantityToBuy);
    }
}
