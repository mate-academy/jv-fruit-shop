package core.basesyntax.service.handlerfruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyFruitsHandlerImp implements FruitsHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                Storage.fruits.get(fruitTransaction.getFruitName())
                        + fruitTransaction.getQuantity());
    }
}
