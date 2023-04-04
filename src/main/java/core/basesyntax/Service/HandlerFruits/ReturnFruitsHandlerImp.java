package core.basesyntax.Service.HandlerFruits;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnFruitsHandlerImp implements FruitsHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitName(),
                Storage.fruits.get(fruitTransaction.getFruitName())
                        + fruitTransaction.getQuantity());
    }
}
