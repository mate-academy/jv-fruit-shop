package core.basesyntax.service.handlerfruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitsHandlerImp implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) throws RuntimeException {
        if (fruitTransaction.getQuantity() == 0) {
            throw new RuntimeException("Quantity zero, impossible to take away!");
        }
        Integer lastSum = Storage.fruits.get(fruitTransaction.getFruitName());
        Storage.fruits.put(fruitTransaction.getFruitName(),
                lastSum - fruitTransaction.getQuantity());
    }
}
