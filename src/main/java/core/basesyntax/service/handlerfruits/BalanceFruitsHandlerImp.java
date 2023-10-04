package core.basesyntax.service.handlerfruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitsHandlerImp implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                fruitTransaction.getQuantity());
    }
}
