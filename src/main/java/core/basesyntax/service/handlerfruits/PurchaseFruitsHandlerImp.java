package core.basesyntax.service.handlerfruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitsHandlerImp implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer lastSum = Storage.fruits.get(fruitTransaction.getFruitName());

        if (fruitTransaction.getQuantity() == 0) {
            throw new RuntimeException("cannot be taken from zero!");
        }

        Storage.fruits.put(fruitTransaction.getFruitName(),
                lastSum - fruitTransaction.getQuantity());
    }
}
