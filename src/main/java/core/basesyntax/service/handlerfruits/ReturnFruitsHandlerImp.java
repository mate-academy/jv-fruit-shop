package core.basesyntax.service.handlerfruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnFruitsHandlerImp implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                Storage.fruits.get(fruitTransaction.getFruitName())
                        + fruitTransaction.getQuantity());
    }
}
