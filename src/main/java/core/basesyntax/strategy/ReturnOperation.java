package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;
import exception.OperationException;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        String fruit = shopOperation.getFruit();
        if (!Storage.fruitsStorage.containsKey(fruit)) {
            throw new OperationException("Operation is not correct: " + shopOperation);
        }
        int quantity = Storage.fruitsStorage.get(fruit);
        Storage.fruitsStorage.put(fruit, quantity + shopOperation.getQuantity());
    }
}
