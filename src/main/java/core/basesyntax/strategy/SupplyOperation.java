package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;
import exception.OperationException;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        try {
            String fruit = shopOperation.getFruit();
            int quantity = Storage.fruitsStorage.get(fruit);
            Storage.fruitsStorage.put(fruit, quantity + shopOperation.getQuantity());
        } catch (NullPointerException e) {
            throw new OperationException("Operation is not correct: " + shopOperation);
        }
    }
}
