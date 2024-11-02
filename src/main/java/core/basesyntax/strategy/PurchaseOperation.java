package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;
import exception.OperationException;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        try {
            String fruit = shopOperation.getFruit();
            int quantity = Storage.fruitsStorage.get(fruit);
            int quantityToBuy = shopOperation.getQuantity();
            if (quantity < quantityToBuy) {
                throw new OperationException("Operation is impossible, not enough quantity of: "
                        + fruit);
            }
            Storage.fruitsStorage.put(fruit, quantity - quantityToBuy);
        } catch (NullPointerException e) {
            throw new OperationException("Operation is not correct: " + shopOperation);
        }

    }
}
